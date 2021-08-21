package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();

		// primeira abordagem de tratamento de exceções
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
		});
		
		// segunda abordagem de tratamento de exceções
		/*
		try {
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			Assertions.fail("Exceção de bonus de salário excedido não lançada");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("Funcionario não elegível a bonus", e.getMessage());
		}
		*/
	}

	@Test
	void bonusDeveriaSer10PorcentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		Assertions.assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorcentoParaSalarioDeExatamente10_000Reais() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
