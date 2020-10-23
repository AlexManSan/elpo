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

import com.elpo.domain.Paciente;
import com.elpo.repository.PacienteRepository;
import com.elpo.sistema.event.RecursoCriadoEvent;

/**
 * Recurso de Paciente caminho de acesso: http://localhost:8080/pacientes
 * Classe de Recurso atenção para:
 * Status Code: 
 * 2xx -> Sucesso
 * 4xx -> Erro do Cliente (culpa de quem chamou a api)
 * 5xx -> Erro no Serviço/Servidor
 * 
 * @author Alex
 */
@RestController // já converte pra json
@RequestMapping("/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteRepository dao;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	/**
	 * http://localhost:8080/pacientes 
	 * 200 ok
	 * @return
	 */
	@GetMapping
	public List<Paciente> listar() {
		System.out.println("Entrei no método @GetMapping listar() /pacientes");
		List<Paciente> lista = dao.findAllOrderNomeAsc();
		
//		for(Paciente c: lista) {
//			System.out.println(c.getId() + " - " + c.getDescricao());
//		}
		
		return lista;
	}
	
	/**
     * http://localhost:8080/pacientes/{id}
     * @param codigo
     * @return 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorCodigo(@PathVariable Long id){
        System.out.println("Entrei no método @GetMapping({id}) pacientes");
        Optional<Paciente> obj = dao.findById(id);
		return obj.isPresent() ? ResponseEntity.ok(obj.get()) : ResponseEntity.notFound().build();  
         
    }

    
	/**
	 * Configurado somente para Criar http://localhost:8080/pacientes 
	 * 201 created
	 * @param obj
	 * @return
	 */
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED) // retorna o 201 created não preciso deste porque ja estou retornando 
	public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente obj, HttpServletResponse response) {
		System.out.println("Entrei no método @PostMapping pacientes");
		Paciente objSalvo = dao.save(obj);
		
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
     * http://localhost:8080/pacientes/{id}
     * @param codigo
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void remover(@PathVariable Long id){
        System.out.println("Entrei no método @DeleteMapping({id}) pacientes");
        dao.deleteById(id);  
    } 
    
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @Valid @RequestBody Paciente obj){
    	System.out.println("Entrei no método @PutMapping(/{id}) pacientes" + id);
    	Optional<Paciente> objOpt = dao.findById(id);
        Paciente objSalvo = objOpt.get();
    	BeanUtils.copyProperties(obj, objSalvo, "id");
    	dao.save(objSalvo);
    	return ResponseEntity.ok(objSalvo);
    }
    
}
