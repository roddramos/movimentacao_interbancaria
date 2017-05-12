package com.accesstage.movimentacao_interbancaria.layout;

public class LayoutSaidaBuilder {
	protected String cpf;
	protected String favorecido;
	protected String agencia;
	protected String contaComDigito;
	protected String valorComDecimal;
	protected String tipoTransacao;
	protected String dataTransacao;

	public LayoutSaidaBuilder whithLayoutEntrada(LayoutEntrada layout) {
		this.cpf = layout.getCpf();
		this.favorecido = layout.getFavorecido();
		this.agencia = layout.getAgencia();
		this.contaComDigito = layout.getConta() + layout.getDigitoConta();
		this.valorComDecimal = layout.getValorTransacaoSemDecimais() + layout.getValorTransacaoDecimais();
		this.tipoTransacao = layout.getTipoTransacao();
		this.dataTransacao = layout.getDataTransacao();
		return this;
	}

	public LayoutSaidaBuilder withCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public LayoutSaidaBuilder withFavorecido(String favorecido) {
		this.favorecido = favorecido;
		return this;
	}

	public LayoutSaidaBuilder withAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	public LayoutSaidaBuilder withContaComDigito(String contaComDigito) {
		this.contaComDigito = contaComDigito;
		return this;
	}

	public LayoutSaidaBuilder withValorComDecimal(String valorComDecimal) {
		this.valorComDecimal = valorComDecimal;
		return this;
	}

	public LayoutSaidaBuilder withTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
		return this;
	}

	public LayoutSaidaBuilder withDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
		return this;
	}

	public LayoutSaida build() {
		return new LayoutSaidaDefault(this);
	}

}
