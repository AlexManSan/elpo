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

import com.elpo.domain.Recomendacoes;
import com.elpo.domain.TpPosicaoCirurgica;
import com.elpo.repository.RecomendacoesRepository;
import com.elpo.repository.TpPosicaoCirurgicaRepository;
import com.elpo.sistema.event.RecursoCriadoEvent;

/**
 * Recurso de Recomendacoes caminho de acesso: http://localhost:8080/recomendacoes
 * Classe de Recurso atenção para:
 * Status Code: 
 * 2xx -> Sucesso
 * 4xx -> Erro do Cliente (culpa de quem chamou a api)
 * 5xx -> Erro no Serviço/Servidor
 * 
 * @author Alex
 */
@RestController // já converte pra json
@RequestMapping("/recomendacoes")
public class RecomendacoesResource {

	@Autowired
	private RecomendacoesRepository dao;
	
	@Autowired
	private TpPosicaoCirurgicaRepository daoTpPosCir;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	/**
	 * http://localhost:8080/recomendacoes 
	 * 200 ok
	 * @return
	 */
	@GetMapping
	public List<Recomendacoes> listar() {
		System.out.println("Entrei no método @GetMapping listar() /recomendacoes");
		List<Recomendacoes> lista = dao.findAll();
		
//		for(Comorbidade c: lista) {
//			System.out.println(c.getId() + " - " + c.getDescricao());
//		}
		
		return lista;
	}
	
	/**
     * http://localhost:8080/recomendacoes/{id}
     * @param codigo
     * @return 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recomendacoes> buscarPorCodigo(@PathVariable Long id){
        System.out.println("Entrei no método @GetMapping({id})");
        Optional<Recomendacoes> obj = dao.findById(id);
		return obj.isPresent() ? ResponseEntity.ok(obj.get()) : ResponseEntity.notFound().build();  
         
    }
    
    /**
     * http://localhost:8080/recomendacoes/tpposicaocirurgica/{id}
     * @param codigo
     * @return 
     */
    @GetMapping("/tpposicaocirurgica/{id}")
    public List<Recomendacoes> buscarPorTpPosicaoCirurgica(@PathVariable Long id){
        System.out.println("Entrei no método @GetMapping buscarPorTpPosicaoCirurgica(id) /recomendacoes/tpposicaocirurgica/{id}");
        Optional<TpPosicaoCirurgica> obj = daoTpPosCir.findById(id);
        TpPosicaoCirurgica objBanco = obj.get();
        List<Recomendacoes> lista = null;
        
        if(objBanco != null){
        	lista = dao.findByTpPosicaoCirurgica(objBanco);
        }
		return lista;
    }

    
	/**
	 * Configurado somente para Criar http://localhost:8080/tpposicaocirurgica 
	 * 201 created
	 * @param obj
	 * @return
	 */
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED) // retorna o 201 created não preciso deste porque ja estou retornando 
	public ResponseEntity<Recomendacoes> criar(@Valid @RequestBody Recomendacoes obj, HttpServletResponse response) {
		System.out.println("Entrei no método @PostMapping");
		Recomendacoes objSalvo = dao.save(obj);
		
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
     * http://localhost:8080/tpposicaocirurgica/{id}
     * @param codigo
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void remover(@PathVariable Long id){
        System.out.println("Entrei no método @DeleteMapping({id})");
        dao.deleteById(id);  
    } 
    
    @PutMapping("/{id}")
    public ResponseEntity<Recomendacoes> atualizar(@PathVariable Long id, @Valid @RequestBody Recomendacoes obj){
    	System.out.println("Entrei no método @PutMapping(/{id})" + id);
    	Optional<Recomendacoes> objOpt = dao.findById(id);
    	Recomendacoes objSalvo = objOpt.get();
    	BeanUtils.copyProperties(obj, objSalvo, "id");
    	dao.save(objSalvo);
    	return ResponseEntity.ok(objSalvo);
    }
    
}
