package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajustesServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void setUp() {
		service = new ReajusteService();
		funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000"));
		System.out.println("inicio");
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("fim");
	}
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Antes de todos");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Após de todos");
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		service.reajustar(funcionario, Desempenho.A_DESEJAR);
		
		Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerQuinzePorcentoQuandoDesempenhoForBom() {
		service.reajustar(funcionario, Desempenho.BOM);
		
		Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerVintePorcentoQuandoDesempenhoForOtimo() {
		service.reajustar(funcionario, Desempenho.OTIMO);
		
		Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
