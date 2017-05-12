package com.accesstage.movimentacao_interbancaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesstage.movimentacao_interbancaria.layout.LayoutEntrada;

public interface LayoutEntradaRepository extends JpaRepository<LayoutEntrada, Long> {

	List<LayoutEntrada> findByInstituicaoRemetente(String intRemetente);

	List<LayoutEntrada> findByInstituicaoRemetenteAndInstituicaoDestinataria(String intRemetente,
			String intDestinataria);
}
