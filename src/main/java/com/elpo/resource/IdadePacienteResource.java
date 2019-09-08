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

import com.elpo.domain.IdadePaciente;
import com.elpo.repository.IdadePacienteRepository;
import com.elpo.sistema.event.RecursoCriadoEvent;

/**
 * Recurso de Comorbidade caminho de acesso: http://localhost:8080/idade_pacientes
 * Classe de Recurso atenção para:
 * Status Code: 
 * 2xx -> Sucesso
 * 4xx -> Erro do Cliente (culpa de quem chamou a api)
 * 5xx -> Erro no Serviço/Servidor
 * 
 * @author Alex
 */
@RestController // já converte pra json
@RequestMapping("/idade_pacientes")
public class IdadePacienteResource {

	@Autowired
	private IdadePacienteRepository dao;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	/**
	 * http://localhost:8080/idade_pacientes 
	 * 200 ok
	 * @return
	 */
	@GetMapping
	public List<IdadePaciente> listar() {
		System.out.println("Entrei no método @GetMapping");	 	
		return dao.findAllOrderIdadeAsc();
	}
	
	/**
     * http://localhost:8080/idade_pacientes/{id}
     * @param codigo
     * @return 
     */
    @GetMapping("/{id}")
    public ResponseEntity<IdadePaciente> buscarPorCodigo(@PathVariable Long id){
        System.out.println("Entrei no método @GetMapping({id})");
        Optional<IdadePaciente> obj = dao.findById(id);
		return obj.isPresent() ? ResponseEntity.ok(obj.get()) : ResponseEntity.notFound().build();  
         
    }

    
	/**
	 * Configurado somente para Criar http://localhost:8080/idade_pacientes 
	 * 201 created
	 * @param obj
	 * @return
	 */
	@PostMapping
	public ResponseEntity<IdadePaciente> criar(@Valid @RequestBody IdadePaciente obj, HttpServletResponse response) {
		System.out.println("Entrei no método @PostMapping");
		IdadePaciente objSalvo = dao.save(obj);
		
		eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, objSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(objSalvo);
	}
	
	/**
     * http://localhost:8080/idade_pacientes/{id}
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
    public ResponseEntity<IdadePaciente> atualizar(@PathVariable Long id, @Valid @RequestBody IdadePaciente obj){
    	System.out.println("Entrei no método @PutMapping(/{id})" + id);
    	Optional<IdadePaciente> objOpt = dao.findById(id);
    	IdadePaciente objSalvo = objOpt.get();
    	BeanUtils.copyProperties(obj, objSalvo, "id");
    	dao.save(objSalvo);
    	return ResponseEntity.ok(objSalvo);
    }
    
}
