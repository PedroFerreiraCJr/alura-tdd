package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
	public void reajustar(Funcionario funcionario, Desempenho desempenho) {
		DesempenhoStrategy strategy = DesempenhoStrategyFactory.getInstance().getDesempenhoStrategy(desempenho);
		strategy.reajustar(funcionario);
	}
}
