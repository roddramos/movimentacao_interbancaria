package com.accesstage.movimentacao_interbancaria.layout;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "layout_entrada")
public class LayoutEntrada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "tipo_transacao")
	private String tipoTransacao;

	@Column(name = "agencia")
	private String agencia;

	@Column(name = "conta")
	private String conta;

	@Column(name = "digito_conta")
	private String digitoConta;

	@Column(name = "favorecido")
	private String favorecido;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "valor_transacao_sem_decimais")
	private String valorTransacaoSemDecimais;

	@Column(name = "valor_transacao_decimais")
	private String valorTransacaoDecimais;

	@Column(name = "data_transacao")
	private String dataTransacao;

	@Column(name = "instituicao_remetente")
	private String instituicaoRemetente;

	@Column(name = "instituicao_destinataria")
	private String instituicaoDestinataria;

	public Long getId() {
		return id;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return conta;
	}

	public String getDigitoConta() {
		return digitoConta;
	}

	public String getFavorecido() {
		return favorecido;
	}

	public String getCpf() {
		return cpf;
	}

	public String getValorTransacaoSemDecimais() {
		return valorTransacaoSemDecimais;
	}

	public String getValorTransacaoDecimais() {
		return valorTransacaoDecimais;
	}

	public String getDataTransacao() {
		return dataTransacao;
	}

	public String getInstituicaoRemetente() {
		return instituicaoRemetente;
	}

	public String getInstituicaoDestinataria() {
		return instituicaoDestinataria;
	}

	public LayoutEntrada(){
		
	}
	public LayoutEntrada(LayoutEntradaBuilder layoutEntradaBuilder) {
		this.tipoTransacao = layoutEntradaBuilder.tipoTransacao;
		this.agencia = layoutEntradaBuilder.agencia;
		this.conta = layoutEntradaBuilder.conta;
		this.digitoConta = layoutEntradaBuilder.digitoConta;
		this.favorecido = layoutEntradaBuilder.favorecido;
		this.cpf = layoutEntradaBuilder.cpf;
		this.valorTransacaoSemDecimais = layoutEntradaBuilder.valorTransacaoSemDecimais;
		this.valorTransacaoDecimais = layoutEntradaBuilder.valorTransacaoDecimais;
		this.dataTransacao = layoutEntradaBuilder.dataTransacao;
		this.instituicaoRemetente = layoutEntradaBuilder.instituicaoRemetente;
		this.instituicaoDestinataria = layoutEntradaBuilder.instituicaoDestinataria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}

	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setValorTransacaoSemDecimais(String valorTransacaoSemDecimais) {
		this.valorTransacaoSemDecimais = valorTransacaoSemDecimais;
	}

	public void setValorTransacaoComDecimais(String valorTransacaoComDecimais) {
		this.valorTransacaoDecimais = valorTransacaoComDecimais;
	}

	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public void setValorTransacaoDecimais(String valorTransacaoDecimais) {
		this.valorTransacaoDecimais = valorTransacaoDecimais;
	}

	public void setInstituicaoRemetente(String instituicaoRemetente) {
		this.instituicaoRemetente = instituicaoRemetente;
	}

	public void setInstituicaoDestinataria(String instituicaoDestinataria) {
		this.instituicaoDestinataria = instituicaoDestinataria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LayoutEntrada other = (LayoutEntrada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
