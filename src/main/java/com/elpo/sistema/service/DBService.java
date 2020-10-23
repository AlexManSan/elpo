package com.elpo.sistema.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elpo.domain.Comorbidade;
import com.elpo.domain.Elpo;
import com.elpo.domain.IdadePaciente;
import com.elpo.domain.Paciente;
import com.elpo.domain.PosicaoMembros;
import com.elpo.domain.Recomendacoes;
import com.elpo.domain.SuperficieSuporte;
import com.elpo.domain.TpAnestesia;
import com.elpo.domain.TpCirurgia;
import com.elpo.domain.TpPosicaoCirurgica;
import com.elpo.repository.ComorbidadeRepository;
import com.elpo.repository.ElpoRepository;
import com.elpo.repository.IdadePacienteRepository;
import com.elpo.repository.PacienteRepository;
import com.elpo.repository.PosicaoMembrosRepository;
import com.elpo.repository.RecomendacoesRepository;
import com.elpo.repository.SuperficieSuporteRepository;
import com.elpo.repository.TpAnestesiaRepository;
import com.elpo.repository.TpCirurgiaRepository;
import com.elpo.repository.TpPosicaoCirurgicaRepository;

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
	
	@Autowired
	private TpCirurgiaRepository tcRep;
	
	@Autowired
	private TpPosicaoCirurgicaRepository tpRep;
	
	@Autowired
	private RecomendacoesRepository recRep;
	
	@Autowired
	private PacienteRepository pacRep;
	
	@Autowired
	private ElpoRepository elpoRep;
	
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
		
		System.out.println(">>>>>>>>>>>>> Criando Tempo de Cirurgia >>>>>>>>>>>>>>>>");
		TpCirurgia tc1 = new TpCirurgia("até 1h", 1);
		TpCirurgia tc2 = new TpCirurgia("acima de 1h até 2h", 2);
		TpCirurgia tc3 = new TpCirurgia("acima de 2h até 4 hora", 3);
		TpCirurgia tc4 = new TpCirurgia("acima de 4h até 6 horas", 4);
		TpCirurgia tc5 = new TpCirurgia("acima de 6h", 5);
		tcRep.saveAll(Arrays.asList(tc1,tc2,tc3,tc4,tc5));
		
		System.out.println(">>>>>>>>>>>>> Criando Tipo de Posição Cirurgica >>>>>>>>>>>>>>>>");
		TpPosicaoCirurgica tp1 = new TpPosicaoCirurgica("Supina", 1, "../../assets/img/P-Supina.png");
		TpPosicaoCirurgica tp2 = new TpPosicaoCirurgica("Lateral", 2, "../../assets/img/P-Lateral_Renal.png");
		TpPosicaoCirurgica tp3 = new TpPosicaoCirurgica("Trendelemburg", 3, "../../assets/img/P-Trendelemburg.png");
		TpPosicaoCirurgica tp4 = new TpPosicaoCirurgica("Prona", 4, "../../assets/img/P-Prona.png");
		TpPosicaoCirurgica tp5 = new TpPosicaoCirurgica("Litotômica", 5, "../../assets/img/P-Litotomica.png");
		tpRep.saveAll(Arrays.asList(tp1,tp2,tp3,tp4,tp5));
		
		System.out.println(">>>>>>>>>>>>> Criando as recomendações de acordo com a posição cirúrgica Supina >>>>>>>>>>>>>>>>");
		Recomendacoes recs1 = new Recomendacoes("CABEÇA", "Utilizar travesseiros ou apoios de cabeça, no formato de pudim, macio e em tamanho adequado ao tamanho da cabeça do paciente", tp1);
		Recomendacoes recs2 = new Recomendacoes("PESCOÇO", "Manter alinhamento: mento-esternal, cabeça e coluna", tp1);
		Recomendacoes recs3 = new Recomendacoes("BRAÇOS", "Os braços podem estar ao longo do corpo, com as palmas das mãos voltadas para o quadril e fixos com auxílio de lençol móvel ou faixa larga; ou em braçadeiras, com as palmas das mãos voltadas para cima e em um ângulo máximo de 80° a 90° com o corpo", tp1);
		Recomendacoes recs4 = new Recomendacoes("PERNAS", "Manter as pernas descruzadas,\r\n" + 
				"Fixar o paciente na mesa por meio de uma faixa larga na região da coxa,\r\n" + 
				"Colocar um travesseiro macio e largo abaixo dos joelhos, para redistribuir a\r\n" + 
				"pressão na região sacra,\r\n" + 
				"Colocar um apoio abaixo da panturrilha.", tp1);
		Recomendacoes recs5 = new Recomendacoes("PÉS", "Manter os calcâneos flutuantes,\r\n" + 
				"Evitar hiperextensão dos pés.", tp1);
		Recomendacoes recs6 = new Recomendacoes("VARIAÇÕES DA POSIÇÃO", "Trendelemburg: Aplicar os mesmos cuidados gerais da posição supina; se\r\n" + 
				"necessário, utilizar apoio na região muscular nos ombros e faixa larga em coxa.\r\n" + 
				"Trendelemburg reverso: durante a fixação do paciente, utilizar faixas largas em\r\n" + 
				"região de braços e coxas.", tp1);

		System.out.println(">>>>>>>>>>>>> Criando as recomendações de acordo com a posição cirúrgica Litotômica >>>>>>>>>>>>>>>>");
		Recomendacoes recl1 = new Recomendacoes("CABEÇA", "Utilizar apoio de cabeça em tamanho adequado ao tamanho", tp5);
		Recomendacoes recl2 = new Recomendacoes("PESCOÇO", "Manter alinhamento: mento-esternal, cabeça e coluna", tp5);
		Recomendacoes recl3 = new Recomendacoes("BRAÇOS", "Manter os membros superiores afastados do peito, para facilitar a respiração, e\r\n" + 
				"em braçadeiras, com as palmas das mãos voltadas para cima e em um ângulo\r\n" + 
				"máximo de 90° com o corpo.", tp5);
		Recomendacoes recl4 = new Recomendacoes("TRONCO", "Amenizar a pressão no quadril e nádegas.", tp5);
		Recomendacoes recl5 = new Recomendacoes("PERNAS", "Utilizar a menor elevação das pernas possível, angulo máximo de 90º\r\n" + 
				"Minimizar o grau de abdução do quadril, abertura de no máximo 90º\r\n" + 
				"Colocar superfície de suportes nas regiões mais extensas do corpo do paciente", tp5);
		Recomendacoes recl6 = new Recomendacoes("PÉS", "Usar apoio adequado (ex. do tipo bota), deixar calcaneo livre de pressão.", tp5);
		
		System.out.println(">>>>>>>>>>>>> Criando as recomendações de acordo com a posição cirúrgica Prona >>>>>>>>>>>>>>>>");
		Recomendacoes recp1 = new Recomendacoes("CABEÇA", "Utilizar apoio de cabeça específico para essa posição, apoiando a face do\r\n" + 
				"paciente no redistribuidor de pressão,\r\n" + 
				"Manter olhos fechados e com lubrificante e Proteger testa, narina e queixo,\r\n" + 
				"Permitir a visualização dos olhos, boca e narina (incluindo o tubo endotraqueal)", tp4);
		Recomendacoes recp2 = new Recomendacoes("PESCOÇO", "Manter alinhamento: mento-esternal, cabeça e coluna", tp4);
		Recomendacoes recp3 = new Recomendacoes("BRAÇOS", "Apoiar os membros superiores com ângulo máximo de 90° entre o braço e o\r\n" + 
				"antebraço, com as palmas voltadas para baixo, em braçadeiras acolchoadas,\r\n" + 
				"que se localizem alinhadas ou abaixo do tronco", tp4);
		Recomendacoes recp4 = new Recomendacoes("TRONCO", "Utilizar coxim horizontal em região de linha axilar e do tórax,\r\n" + 
				"Utilizar suporte adequado ao paciente para apoio do tronco ou colocar coxins\r\n" + 
				"em formato de rolos, da clavícula à crista ilíaca\r\n" + 
				"Atentar-se às mamas, genitálias.", tp4);
		Recomendacoes recp5 = new Recomendacoes("PERNAS", "Colocar travesseiro sob os membros inferiores, deixar joelhos livres.", tp4);
		Recomendacoes recp6 = new Recomendacoes("PÉS", "Garantir a posição anatômica dos pés.", tp4);
		Recomendacoes recp7 = new Recomendacoes("VARIAÇÕES DA POSIÇÃO", "Kraske ou Jacknife: cuidados gerais da posição prona;\r\n" + 
				"Oferecer atenção especial no momento da “quebra da mesa”,\r\n" + 
				"Evitar pressão inadequada em proeminências ósseas, como crista ilíaca.", tp4);
		
		System.out.println(">>>>>>>>>>>>> Criando as recomendações de acordo com a posição cirúrgica Lateral >>>>>>>>>>>>>>>>");
		Recomendacoes rec1 = new Recomendacoes("CABEÇA", "Apoiar a cabeça em coxins ou travesseiros,\r\n" + 
				"Inspecionar e proteger o lóbulo da orelha do lado de apoio,", tp2);
		Recomendacoes rec2 = new Recomendacoes("PESCOÇO", "Manter alinhamento: mento-esternal, cabeça e coluna", tp2);
		Recomendacoes rec3 = new Recomendacoes("BRAÇOS", "Apoiar o braço inferior em braçadeira em ângulo máximo de 90° com a mesa\r\n" + 
				"operatória,\r\n" + 
				"Apoiar o braço superior em acessório específico paralelo à braçadeira inferior\r\n" + 
				"ou em travesseiro desalinhado com o braço inferior,", tp2);
		Recomendacoes rec4 = new Recomendacoes("TRONCO", "Colocar coxim horizontalmente na região abaixo da axila,\r\n" + 
				"Atentar-se e proteger as proeminências ósseas na região lateral do quadril,\r\n" + 
				"Colocar faixas largas para fixação do paciente em região de quadril e coxa.", tp2);
		Recomendacoes rec5 = new Recomendacoes("PERNAS", "Manter flexionada, na altura do quadril, a perna em contato com a mesa;\r\n" + 
				"Manter esticada a perna “superior” apoiada em travesseiro ou coxim.", tp2);
		Recomendacoes rec6 = new Recomendacoes("PÉS", "Manter os pés em posição anatômica, com as laterais dos calcâneos livres de\r\n" + 
				"pressão.", tp2);
		Recomendacoes rec7 = new Recomendacoes("VARIAÇÕES DA POSIÇÃO", "Lateral Renal: atenção especial à hiperextensão da região das costelas\r\n" + 
				"O tempo de flexão da mesa deve ser restrito ao estritamente necessário", tp2);
		recRep.saveAll(Arrays.asList(recs1,recs2,recs3,recs4,recs5,recs6,recl1,recl2,recl3,recl4,recl5,recl6,recp1,recp2,recp3,recp4,recp5,recp6,recp7,rec1,rec2,rec3,rec4,rec5,rec6,rec7));
	
		System.out.println(">>>>>>>>>>>>> Criando Paciente >>>>>>>>>>>>>>>>");
		Paciente p1 = new Paciente("Alex Santos", 83, 3456);
		Paciente p2 = new Paciente("João", 35, 357);
		Paciente p3 = new Paciente("Maria", 56, 568);
		Paciente p4 = new Paciente("Ana", 78, 789);
		Paciente p5 = new Paciente("Carlos", 43, 435);
		pacRep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		System.out.println(">>>>>>>>>>>>> Criando Elpo >>>>>>>>>>>>>>>>");
		Elpo e1 = new Elpo(LocalDate.now(), 35, "Alto", p1, tp5, ss5, tc5, pm5, ta5, ip5, como5);
		Elpo e2 = new Elpo(LocalDate.of(2020, 07, 05), 25, "Alto", p2, tp4, ss4, tc4, pm4, ta4, ip1, como4);
		Elpo e3 = new Elpo(LocalDate.of(2020, 07, 04), 20, "Alto", p3, tp3, ss3, tc3, pm3, ta3, ip2, como3);
		Elpo e4 = new Elpo(LocalDate.of(2020, 07, 03), 16, "Baixo", p4, tp2, ss2, tc2, pm2, ta2, ip4, como2);
		Elpo e5 = new Elpo(LocalDate.of(2020, 07, 02), 8, "Baixo", p5, tp1, ss1, tc1, pm1, ta1, ip2, como1);
		elpoRep.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
	}
}
