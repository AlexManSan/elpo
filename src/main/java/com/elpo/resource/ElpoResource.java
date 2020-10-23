package com.elpo.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elpo.domain.Elpo;
import com.elpo.domain.Paciente;
import com.elpo.repository.ElpoRepository;
import com.elpo.repository.PacienteRepository;
import com.elpo.sistema.event.RecursoCriadoEvent;

/**
 * Recurso da Elpo caminho de acesso: http://localhost:8080/elpos
 * Classe de Recurso atenção para:
 * Status Code: 
 * 2xx -> Sucesso
 * 4xx -> Erro do Cliente (culpa de quem chamou a api)
 * 5xx -> Erro no Serviço/Servidor
 * 
 * @author Alex
 */
@RestController // já converte pra json
@RequestMapping("/elpos")
public class ElpoResource {

	@Autowired
	private ElpoRepository dao;
	
	@Autowired
	private PacienteRepository pacdao;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	/**
	 * http://localhost:8080/elpos 
	 * 200 ok
	 * @return
	 */
	@GetMapping
	public List<Elpo> listar() {
		System.out.println("Entrei no método @GetMapping listar() /elpos");
		List<Elpo> lista = dao.findAll();	
		return lista;
	}
	
	/**
	 * Pesquisa registros da elpo por prontuário digitado.
	 * @param pront
	 * @return
	 */
	@GetMapping("/pesq/{pront}")
	public List<Elpo> pesquisar(@PathVariable Integer pront) {
		System.out.println("Entrei no método @GetMapping Pesquisar() /elpos/pesq/{pront}");
		List<Elpo> lista = null;
		Paciente p = pacdao.findByProntuario(pront);
		
		if(p != null) {
			lista = dao.findAllByPaciente(p);	
		}
		return lista;
	}
	
	/**
	 * Carrega registros da elpo buscando pelo nome do paciente.
	 * @param nome
	 * @return
	 */
	@GetMapping("/pesq/paciente/{nome}")
	public List<Elpo> pesquisarPaciente(@PathVariable String nome) {
		System.out.println("Entrei no método @GetMapping Pesquisar() /elpos/pesq/paciente/{nome}");
		List<Elpo> lista = null;
		Paciente p = pacdao.findByNomeContains(nome);
		
		if(p != null) {
			lista = dao.findAllByPaciente(p);	
		}
		return lista;
	}
	
	/**
     * http://localhost:8080/elpos/{id}
     * @param codigo
     * @return 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Elpo> buscarPorCodigo(@PathVariable Long id){
        System.out.println("Entrei no método @GetMapping({id})");
        Optional<Elpo> obj = dao.findById(id);
		return obj.isPresent() ? ResponseEntity.ok(obj.get()) : ResponseEntity.notFound().build();  
         
    }

    
	/**
	 * Configurado somente para Criar http://localhost:8080/elpos 
	 * 201 created
	 * @param obj
	 * @return
	 */
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED) // retorna o 201 created não preciso deste porque ja estou retornando 
	public ResponseEntity<Elpo> criar(@Valid @RequestBody Elpo obj, HttpServletResponse response) {
		System.out.println("Entrei no método @PostMapping elpo");
		
		Paciente pac = pacdao.findByProntuario(obj.getPaciente().getProntuario());
		if(pac != null) {
			obj.setPaciente(pac);
		}else {
			pac = pacdao.save(obj.getPaciente());
			obj.setPaciente(pac);
		}
		Elpo objSalvo = dao.save(obj);
		
		// depois de criar o objeto eu informo para o heder location o caminho para recuperar o cadastro criado
		// que será http://localhost:8080/comorbidades/10
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(objSalvo.getId())
//				.toUri();
//		response.setHeader("Location", uri.toASCIIString());
		
		eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, objSalvo.getId()));
		
		// devolvendo a comorbidade criada com retorno 201 created
//		return ResponseEntity.created(uri).body(objSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(objSalvo);
	}
	
	/**
     * http://localhost:8080/elpos/{id}
     * @param codigo
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void remover(@PathVariable Long id){
        System.out.println("Entrei no método @DeleteMapping({id}) elpo");
        dao.deleteById(id);  
    } 
    
    @PutMapping("/{id}")
    public ResponseEntity<Elpo> atualizar(@PathVariable Long id, @Valid @RequestBody Elpo obj){
    	System.out.println("Entrei no método @PutMapping(/{id}) elpo: " + id);
    	Optional<Elpo> objOpt = dao.findById(id);
    	System.out.println(objOpt.get());
    	Elpo objSalvo = objOpt.get();
    	BeanUtils.copyProperties(obj, objSalvo, "id");
    	dao.save(objSalvo);
    	
    	Optional<Paciente> objpac = pacdao.findById(obj.getPaciente().getId());
    	System.out.println(objpac.get());
    	Paciente objpSalvo = objpac.get();
    	BeanUtils.copyProperties(obj.getPaciente(), objpSalvo, "id");
    	pacdao.save(objpSalvo);
    	return ResponseEntity.ok(objSalvo);
    }
    
}
