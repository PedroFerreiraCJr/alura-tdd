package br.com.alura.tdd.service;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.service.impl.DesempenhoADesejar;
import br.com.alura.tdd.service.impl.DesempenhoBom;
import br.com.alura.tdd.service.impl.DesempenhoOtimo;

public class DesempenhoStrategyFactory {

	private static DesempenhoStrategyFactory instance;

	private Map<Desempenho, DesempenhoStrategy> strategies;

	private DesempenhoStrategyFactory() {
		super();
		init();
	}

	private void init() {
		this.strategies = new HashMap<Desempenho, DesempenhoStrategy>();
		this.strategies.put(Desempenho.A_DESEJAR, new DesempenhoADesejar());
		this.strategies.put(Desempenho.BOM, new DesempenhoBom());
		this.strategies.put(Desempenho.OTIMO, new DesempenhoOtimo());
	}

	public static DesempenhoStrategyFactory getInstance() {
		if (instance == null) {
			synchronized (DesempenhoStrategyFactory.class) {
				if (instance == null) {
					instance = new DesempenhoStrategyFactory();
				}
			}
		}

		return instance;
	}

	public DesempenhoStrategy getDesempenhoStrategy(Desempenho desempenho) {
		DesempenhoStrategy strategy = this.strategies.get(desempenho);
		if (strategy != null) {
			return strategy;
		}

		throw new IllegalStateException("Desempenho Strategy desconhecido");
	}
}
