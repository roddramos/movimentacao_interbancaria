package com.accesstage.movimentacao_interbancaria.layout;

import org.apache.commons.lang3.StringUtils;

public class LayoutSaidaDefault implements LayoutSaida {
	private final String cpf;
	private final String favorecido;
	private final String agencia;
	private final String contaComDigito;
	private final String valorComDecimal;
	private final String tipoTransacao;
	private final String dataTransacao;
	private final String linha;

	public LayoutSaidaDefault(LayoutSaidaBuilder layout) {
		this.cpf = layout.cpf;
		this.favorecido = layout.favorecido;
		this.agencia = layout.agencia;
		this.contaComDigito = layout.contaComDigito;
		this.valorComDecimal = layout.valorComDecimal;
		this.tipoTransacao = layout.tipoTransacao;
		this.dataTransacao = layout.dataTransacao;
		this.linha = this.toString();
	}

	public String getCpf() {
		return cpf;
	}

	public String getFavorecido() {
		return favorecido;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return contaComDigito;
	}

	public String getValorComDecimal() {
		return valorComDecimal;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public String getDataTransacao() {
		return dataTransacao;
	}
	
	public String getContaComDigito() {
		return contaComDigito;
	}

	public String getLinha() {
		return linha;
	}

	@Override
	public String toString() {
		return StringUtils.rightPad(cpf, 11) + StringUtils.rightPad(favorecido, 30) + StringUtils.rightPad(agencia, 4)
				+ StringUtils.rightPad(contaComDigito, 4) + StringUtils.rightPad(valorComDecimal, 7)
				+ StringUtils.rightPad(tipoTransacao, 3) + StringUtils.rightPad(dataTransacao, 6);
	}

}
