package br.com.alura.tdd.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.DesempenhoStrategy;

public class DesempenhoOtimo implements DesempenhoStrategy {
	@Override
	public void reajustar(Funcionario f) {
		BigDecimal salario = f.getSalario();
		BigDecimal reajuste = salario.multiply(new BigDecimal("0.20")).setScale(2, RoundingMode.HALF_UP);
		f.reajustarSalario(reajuste);
	}
}
