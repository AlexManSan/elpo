package com.elpo.sistema.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elpo.domain.Comorbidade;
import com.elpo.domain.IdadePaciente;
import com.elpo.domain.PosicaoMembros;
import com.elpo.domain.SuperficieSuporte;
import com.elpo.repository.ComorbidadeRepository;
import com.elpo.repository.IdadePacienteRepository;
import com.elpo.repository.PosicaoMembrosRepository;
import com.elpo.repository.SuperficieSuporteRepository;

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
				
//		System.out.println(">>>>>>>>>>>>> Criando Veículos >>>>>>>>>>>>>>>>");
		
//		Veiculo m1 = new Veiculo(null, honda, "Titan 160c", "LOK-2551", catm, true);
//		Veiculo m2 = new Veiculo(null, honda, "Titan 125c", "LOK-2552", catm, true);
//		Veiculo m3 = new Veiculo(null, yamaha, "Fazer 150c", "LOK-2553", catm, true);
//		
//		Veiculo v1 = new Veiculo(null, fiat, "Uno 1.0 16v", "LAJ-3551", catc, true);
//		Veiculo v2 = new Veiculo(null, fiat, "Palio 1.0 16v", "LAJ-3552", catc, true);
//		Veiculo v3 = new Veiculo(null, chevrolet, "Celta 1.4 16v", "LAJ-3553", catc, true);
//		
//		Veiculo c1 = new Veiculo(null, mercedes, "Caminhão xxx", "CAJ-3553", catca, false);
//		Veiculo o1 = new Veiculo(null, volkswagen, "Volksbus 15.230 OT", "OAJ-5551", cato, true);
//		
//		veiculoRep.saveAll(Arrays.asList(m1, m2, m3, v1, v2, v3, c1, o1));
//		
//		System.out.println(">>>>>>>>>>>>> Criando Usuários >>>>>>>>>>>>>>>>");
////		Usuario u = new Usuario(null, "Alex Manhães dos Santos", "alexmansan@gmail.com", "123456", true, 'A');
//		Usuario um = new Usuario(null, "Alex Mestre", "mestre@gmail.com", "123456", "000000012", TipoUsuario.MESTRE, true);
//		Usuario ui = new Usuario(null, "João Instrutor", "instrutor@gmail.com", "123456", "000000013", TipoUsuario.INSTRUTOR, true);
//		Usuario ui2 = new Usuario(null, "Maria Instrutora", "instrutor2@gmail.com", "123456", "000000014", TipoUsuario.INSTRUTOR, true);
//		Usuario ua = new Usuario(null, "Josefina Aluna", "aluna@gmail.com", "123456", "000000015", TipoUsuario.ALUNO, true);
//		Usuario ua2 = new Usuario(null, "Carlos Aluno", "carlos@gmail.com", "123456", "000000016", TipoUsuario.ALUNO, true);
//		Usuario ud = new Usuario(null, "Tiago Diretor", "diretoria@gmail.com", "123456", "000000017", TipoUsuario.DIRETORIA, true);
//		usuarioRep.saveAll(Arrays.asList(um,ui,ui2,ua,ua2,ud));	
//		
//		System.out.println(">>>>>>>>>>>>> Criando Ficha de Avaliação >>>>>>>>>>>>>>>>");
//		FichaAvaliacao ficha1 = new FichaAvaliacao(null, LocalDate.now(), LocalTime.of(7, 30, 50), LocalTime.of(10, 30, 30),
//				StatusFicha.APROVADO, catm, av1, av2, av3, m1, ua, ui);
//		
//		FichaAvaliacao ficha2 = new FichaAvaliacao(null, LocalDate.now(), LocalTime.of(9, 30, 50), LocalTime.of(11, 30, 30),
//				StatusFicha.APROVADO, catm, av5, av2, av1, m2, ua, ui);
//		fichaRep.saveAll(Arrays.asList(ficha1, ficha2));
//		
//		// fazer as assossiações das listas de faltas para a ficha e da ficha para a falta
//		ficha1.getFaltas().addAll(Arrays.asList(fen,fgn,fmn,fln));
//		ficha2.getFaltas().addAll(Arrays.asList(fg2,fl1));
//		
//		fen.getFichas().addAll(Arrays.asList(ficha1));
//		fgn.getFichas().addAll(Arrays.asList(ficha1));
//		fmn.getFichas().addAll(Arrays.asList(ficha1));
//		fln.getFichas().addAll(Arrays.asList(ficha1));
//		fg2.getFichas().addAll(Arrays.asList(ficha2));
//		fl1.getFichas().addAll(Arrays.asList(ficha2));
//		
//		fichaRep.saveAll(Arrays.asList(ficha1, ficha2));
//		faltaRep.saveAll(Arrays.asList(fen,fgn,fmn,fln,fg2,fl1)); 
//		
	}
}
