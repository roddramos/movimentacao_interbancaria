package com.accesstage.movimentacao_interbancaria.layout;

public abstract class LayoutEntradaBuilder {
	protected String tipoTransacao;
	protected String agencia;
	protected String conta;
	protected String digitoConta;
	protected String favorecido;
	protected String cpf;
	protected String valorTransacaoSemDecimais;
	protected String valorTransacaoDecimais;
	protected String dataTransacao;
	protected String instituicaoRemetente;
	protected String instituicaoDestinataria;

	public abstract LayoutEntradaBuilder carregar(String linhaEntrada);

	public abstract LayoutEntrada build();

	protected LayoutEntradaBuilder withTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
		return this;
	}

	public LayoutEntradaBuilder withInstituicaoRemetente(String instituicaoRemetente) {
		this.instituicaoRemetente = instituicaoRemetente;
		return this;
	}

	public LayoutEntradaBuilder withInstituicaoDestinataria(String instituicaoDestinataria) {
		this.instituicaoDestinataria = instituicaoDestinataria;
		return this;
	}

	protected LayoutEntradaBuilder withAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	protected LayoutEntradaBuilder withConta(String conta) {
		this.conta = conta;
		return this;
	}

	protected LayoutEntradaBuilder withDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
		return this;
	}

	protected LayoutEntradaBuilder withFavorecido(String favorecido) {
		this.favorecido = favorecido;
		return this;
	}

	protected LayoutEntradaBuilder withCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	protected LayoutEntradaBuilder withValorTransacaoSemDecimais(String valorTransacaoSemDecimais) {
		this.valorTransacaoSemDecimais = valorTransacaoSemDecimais;
		return this;
	}

	protected LayoutEntradaBuilder withValorTransacaoDecimais(String valorTransacaoDecimais) {
		this.valorTransacaoDecimais = valorTransacaoDecimais;
		return this;
	}

	protected LayoutEntradaBuilder withDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
		return this;
	}

}
