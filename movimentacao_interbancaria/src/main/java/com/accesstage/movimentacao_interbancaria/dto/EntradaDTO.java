package com.accesstage.movimentacao_interbancaria.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EntradaDTO  {
	@NotNull
	@Size(min=69,max=69)
	private String linha;

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	@Override
	public String toString() {
		return "EntradaUnicaDTO [linha=" + linha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linha == null) ? 0 : linha.hashCode());
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
		EntradaDTO other = (EntradaDTO) obj;
		if (linha == null) {
			if (other.linha != null)
				return false;
		} else if (!linha.equals(other.linha))
			return false;
		return true;
	}

}
