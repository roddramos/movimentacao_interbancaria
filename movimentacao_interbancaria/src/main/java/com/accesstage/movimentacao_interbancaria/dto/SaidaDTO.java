package com.accesstage.movimentacao_interbancaria.dto;

public class SaidaDTO {
	private String linhaEntrada;
	private String linhaSaida;

	public SaidaDTO(String linhaEntrada, String linhaSaida) {
		this.linhaEntrada = linhaEntrada;
		this.linhaSaida = linhaSaida;
	}

	public String getLinhaEntrada() {
		return linhaEntrada;
	}

	public void setLinhaEntrada(String linhaEntrada) {
		this.linhaEntrada = linhaEntrada;
	}

	public String getLinhaSaida() {
		return linhaSaida;
	}

	public void setLinhaSaida(String linhaSaida) {
		this.linhaSaida = linhaSaida;
	}

	@Override
	public String toString() {
		return "SaidaDTO [linhaEntrada=" + linhaEntrada + ", linhaSaida=" + linhaSaida + "]";
	}

}
