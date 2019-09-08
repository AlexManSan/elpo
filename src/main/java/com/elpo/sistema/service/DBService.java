package com.elpo.sistema.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elpo.domain.Comorbidade;
import com.elpo.domain.IdadePaciente;
import com.elpo.domain.PosicaoMembros;
import com.elpo.domain.SuperficieSuporte;
import com.elpo.domain.TpAnestesia;
import com.elpo.repository.ComorbidadeRepository;
import com.elpo.repository.IdadePacienteRepository;
import com.elpo.repository.PosicaoMembrosRepository;
import com.elpo.repository.SuperficieSuporteRepository;
import com.elpo.repository.TpAnestesiaRepository;

@Service
public class DBService {
	
//	@Autowired
//	private BCryptPasswordEncoder pe;

	@Autowired
	private ComorbidadeRepository cormoRep;
	
	@Autowired
	private IdadePacienteRepository idadePacRep;
	
	@Autowired
	private PosicaoMembrosRepository posMemRep;
	
	@Autowired
	private SuperficieSuporteRepository ssRep;
	
	@Autowired
	private TpAnestesiaRepository taRep;
	
	/**
	 * Método responsavel por criar os registros no ambiente de teste
	 * @throws ParseException
	 */
	public void instantiateTestDatabase() throws ParseException {
		System.out.println(">>>>>>>>>>>>> Criando Comorbidades >>>>>>>>>>>>>>>>");
		Comorbidade como1 = new Comorbidade("Sem comorbidade", 1);
		Comorbidade como2 = new Comorbidade("Doença vascular", 2);
		Comorbidade como3 = new Comorbidade("Diabetes mellitus", 3);
		Comorbidade como4 = new Comorbidade("Obesidade ou desnutrição", 4);
		Comorbidade como5 = new Comorbidade("Úlcera por pressão ou neuropatia previamente diagnosticada ou trombose venosa profunda", 5);
		cormoRep.saveAll(Arrays.asList(como1,como2,como3,como4,como5)); 
		
		System.out.println(">>>>>>>>>>>>> Criando IdadePaciente >>>>>>>>>>>>>>>>");
		IdadePaciente ip1 = new IdadePaciente("Entre 18 e 39 anos", 1);
		IdadePaciente ip2 = new IdadePaciente("Entre 40 e 59 anos", 2);
		IdadePaciente ip3 = new IdadePaciente("Entre 60 e 69 anos", 3);
		IdadePaciente ip4 = new IdadePaciente("Entre 70 e 79 anos", 4);
		IdadePaciente ip5 = new IdadePaciente("> 80 anos", 5);
		idadePacRep.saveAll(Arrays.asList(ip1,ip2,ip3,ip4,ip5)); 		
		
		System.out.println(">>>>>>>>>>>>> Criando Posição dos membros >>>>>>>>>>>>>>>>");
		PosicaoMembros pm1 = new PosicaoMembros("Posição Anatômica", 1);
		PosicaoMembros pm2 = new PosicaoMembros("Abertura dos membros superiores < 90º", 2);
		PosicaoMembros pm3 = new PosicaoMembros("Elevação dos joelhos < 90º e abertura dos membros inferiores < 90º ou pescoço sem alinhamento mento-esternal", 3);
		PosicaoMembros pm4 = new PosicaoMembros("Elevação dos joelhos > 90º ou abertura dos membros inferiores > 90º", 4);
		PosicaoMembros pm5 = new PosicaoMembros("Elevação dos joelhos > 90º e abertura dos membros inferiores > 90º ou abertura dos membros superiores > 90º", 5);
		posMemRep.saveAll(Arrays.asList(pm1,pm2,pm3,pm4,pm5));
			
		System.out.println(">>>>>>>>>>>>> Criando Superficie de suporte >>>>>>>>>>>>>>>>");
		SuperficieSuporte ss1 = new SuperficieSuporte("Colchão de mesa cirúrgica de viscoelástico + coxins de viscoelástico", 1);
		SuperficieSuporte ss2 = new SuperficieSuporte("Colchão de mesa cirúrgica de espuma (convencional) + coxins de viscoelástico", 2);
		SuperficieSuporte ss3 = new SuperficieSuporte("Colchão de mesa cirúrgica de espuma (convencional) + coxins de espuma", 3);
		SuperficieSuporte ss4 = new SuperficieSuporte("Colchão de mesa cirúrgica de espuma (convencional) + coxins feitos de campos de algodão", 4);
		SuperficieSuporte ss5 = new SuperficieSuporte("Sem uso de superfície de suporte ou suportes rígidos sem acolchoamento ou perneiras estreitas", 5);
		ssRep.saveAll(Arrays.asList(ss1,ss2,ss3,ss4,ss5));
				
		System.out.println(">>>>>>>>>>>>> Criando Tipo de Anestesia >>>>>>>>>>>>>>>>");
		TpAnestesia ta1 = new TpAnestesia("Local", 1);
		TpAnestesia ta2 = new TpAnestesia("Sedação", 2);
		TpAnestesia ta3 = new TpAnestesia("Regional", 3);
		TpAnestesia ta4 = new TpAnestesia("Geral", 4);
		TpAnestesia ta5 = new TpAnestesia("Geral + Regional", 5);
		taRep.saveAll(Arrays.asList(ta1,ta2,ta3,ta4,ta5));
		
		
	}
}
