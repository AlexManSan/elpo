package com.elpo.sistema.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elpo.domain.Comorbidade;
import com.elpo.repository.ComorbidadeRepository;

@Service
public class DBService {
	
//	@Autowired
//	private BCryptPasswordEncoder pe;

	@Autowired
	private ComorbidadeRepository cormoRep;
	
	
	
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
		
		
//		System.out.println(">>>>>>>>>>>>> Criando Avaliadores >>>>>>>>>>>>>>>>");
//		Avaliador av1 = new Avaliador(null, "Marcos Santos", true);
//		Avaliador av2 = new Avaliador(null, "Manoel Oliveira", true);
//		Avaliador av3 = new Avaliador(null, "Lúcia Soares", true);
//		Avaliador av4 = new Avaliador(null, "Denise Custódio", false);
//		Avaliador av5 = new Avaliador(null, "Henrique da Silva", true);
//		Avaliador av6 = new Avaliador(null, "João Carlos", false);
//		avaliRep.saveAll(Arrays.asList(av1,av2,av3,av4,av5,av6)); 		
//		
//		System.out.println(">>>>>>>>>>>>> Criando Faltas >>>>>>>>>>>>>>>>");
//		String EA="A- Iniciar a prova sem estar com o capacete devidamente ajustado a cabeça ou sem viseira ou óculos de proteção.";
//		String EB="B- Descumprimento do percurso pré-estabelecido.";
//		String EC="C- Abalroar em um ou mais cones de balizamento.";
//		String ED="D- Cair do veículo durante a prova.";
//		String EE="E- Não manter equilíbrio na pracha, saindo lateralmente da mesma.";
//		String EF="F- Avançar sobre o meio fio ou parada obrigatória.";
//		String EG="G- Colocar o(s) pé(s) no chão, com o veículo em movimento.";
//		String EH="H- Fazer percurso com farol apagado.";
//		String EI="I- Cometer qualquer outra infração de trânsito de natureza gravíssima.";
//		String N="Nenhuma falta cometida.";
//		
//		Falta fe1 = new Falta(null, EA, catm, 5);
//		Falta fe2 = new Falta(null, EB, catm, 5);
//		Falta fe3 = new Falta(null, EC, catm, 5);
//		Falta fe4 = new Falta(null, ED, catm, 5);
//		Falta fe5 = new Falta(null, EE, catm, 5);
//		Falta fe6 = new Falta(null, EF, catm, 5);
//		Falta fe7 = new Falta(null, EG, catm, 5);
//		Falta fe8 = new Falta(null, EH, catm, 5);
//		Falta fe9 = new Falta(null, EI, catm, 5);
//		Falta fen = new Falta(null, N, catm, 5);
//		
//		String GA="A- Deixar de colocar um é no chão e outro no freio para parar o veículo.";
//		String GB="B- Invadir qualquer faixa durante o percurso.";
//		String GC="C- Fazer incorretamente a sinalização ou deixar de fazê-la.";
//		String GD="D- Conduzir o veículo durante o exame sem segurar o guidom com ambas as mãos, salvo eventualmente para indicação de manobra.";
//		String GE="E- Cometer qualquer outra infração de trânsito de natureza grave.";
//		
//		Falta fg1 = new Falta(null, GA, catm, 3);
//		Falta fg2 = new Falta(null, GB, catm, 3);
//		Falta fg3 = new Falta(null, GC, catm, 3);
//		Falta fg4 = new Falta(null, GD, catm, 3);
//		Falta fg5 = new Falta(null, GE, catm, 3);
//		Falta fgn = new Falta(null, N, catm, 3);
//		
//		String MA="A- Utilizar incorretamente os equipamentos.";
//		String MB="B- Engrenar ou utilizar marchas inadequadas durante o percurso.";
//		String MC="C- Não recolher o pedal de partida ou o suporte do veículo, antes de iniciar o percurso.";
//		String MD="D- Interrromper o funcionamento do motor sem justa razão, após o início da prova.";
//		String ME="E- Cometer qualquer outra infração de trânsito de natureza média.";
//		
//		Falta fm1 = new Falta(null, MA, catm, 2);
//		Falta fm2 = new Falta(null, MB, catm, 2);
//		Falta fm3 = new Falta(null, MC, catm, 2);
//		Falta fm4 = new Falta(null, MD, catm, 2);
//		Falta fm5 = new Falta(null, ME, catm, 2);
//		Falta fmn = new Falta(null, N, catm, 2);
//		
//		String LA="A- Colocar o motor em funcionamento quando já engrenado.";
//		String LB="B- Conduzir o veículo provocando movimento irregular no mesmo sem motivo justificado.";
//		String LC="C- Regular espelhos retrovisores durante o percurso do exame.";
//		String LD="D- Cometer qualquer outra infração de trânsito de natureza leve.";
//		
//		
//		Falta fl1 = new Falta(null, LA, catm, 1);
//		Falta fl2 = new Falta(null, LB, catm, 1);
//		Falta fl3 = new Falta(null, LC, catm, 1);
//		Falta fl4 = new Falta(null, LD, catm, 1);
//		Falta fln = new Falta(null, N, catm, 1);
//		
//		faltaRep.saveAll(Arrays.asList(fe1,fe2,fe3,fe4,fe5,fe6,fe7,fe8,fe9,fen,
//				fg1,fg2,fg3,fg4,fg5,fgn, fm1,fm2,fm3,fm4,fm5,fmn, fl1,fl2,fl3,fl4,fln));
//		
//		System.out.println(">>>>>>>>>>>>> Criando Marcas >>>>>>>>>>>>>>>>");
//		Marca fiat = new Marca(null, "FIAT");
//		Marca chevrolet = new Marca(null, "CHEVROLET");
//		Marca ford = new Marca(null, "FORD");
//		Marca renault = new Marca(null, "RENAULT");
//		Marca volkswagen = new Marca(null, "VOLKSWAGEN");
//		Marca honda = new Marca(null, "HONDA");
//		Marca yamaha = new Marca(null, "YAMAHA");
//		Marca mercedes = new Marca(null, "MERCEDES");
//		
//		marcaRep.saveAll(Arrays.asList(fiat, chevrolet, ford, renault, volkswagen, honda, yamaha, mercedes)); 
//		
//		System.out.println(">>>>>>>>>>>>> Criando Veículos >>>>>>>>>>>>>>>>");
//		
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
