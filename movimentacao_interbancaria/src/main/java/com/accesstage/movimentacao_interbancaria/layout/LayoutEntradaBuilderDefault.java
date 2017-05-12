package com.accesstage.movimentacao_interbancaria.layout;

public class LayoutEntradaBuilderDefault extends LayoutEntradaBuilder {

	@Override
	public LayoutEntradaBuilder carregar(String linhaEntrada) {
		this.withTipoTransacao(linhaEntrada.substring(0, 3))
			.withAgencia(linhaEntrada.substring(3, 7))
			.withConta(linhaEntrada.substring(7, 12))
			.withDigitoConta(linhaEntrada.substring(12, 13))
			.withFavorecido(linhaEntrada.substring(13, 43))
			.withCpf(linhaEntrada.substring(43, 54))
			.withValorTransacaoSemDecimais(linhaEntrada.substring(54, 59))
			.withValorTransacaoDecimais(linhaEntrada.substring(59, 61))
			.withDataTransacao(linhaEntrada.substring(61));
		return this;
	}

	@Override
	public LayoutEntrada build() {
		return new LayoutEntrada(this);
	}

}
