package com.accesstage.movimentacao_interbancaria.service;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accesstage.movimentacao_interbancaria.dto.EntradaDTO;
import com.accesstage.movimentacao_interbancaria.dto.SaidaDTO;
import com.accesstage.movimentacao_interbancaria.layout.LayoutEntrada;
import com.accesstage.movimentacao_interbancaria.layout.LayoutEntradaBuilderDefault;
import com.accesstage.movimentacao_interbancaria.layout.LayoutSaida;
import com.accesstage.movimentacao_interbancaria.layout.LayoutSaidaBuilder;
import com.accesstage.movimentacao_interbancaria.repository.LayoutEntradaRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class LayoutEntradaService {
	@Autowired
	private LayoutEntradaRepository repository;

	@Transactional(readOnly = false)
	public LayoutEntrada salvar(LayoutEntrada layoutEntrada) {
		Validate.notNull(layoutEntrada, "Layout de Entrada não foi informado, verificar!");
		return repository.save(layoutEntrada);
	}

	public LayoutEntrada buscaPorId(Long id) {
		return repository.findOne(id);
	}

	public List<LayoutEntrada> buscaPorInstituicaoRemetente(String instituicaoRem) {
		return repository.findByInstituicaoRemetente(instituicaoRem);
	}

	public List<LayoutEntrada> buscaPorInstituicaoDestinataria(String instituicaoRem, String instituicaoDest) {
		return repository.findByInstituicaoRemetenteAndInstituicaoDestinataria(instituicaoRem, instituicaoDest);
	}

	public SaidaDTO tratar(String remetente, String destinatario, EntradaDTO entradaDTO) {
		LayoutEntrada layoutEntrada = new LayoutEntradaBuilderDefault()
				.carregar(entradaDTO.getLinha())
				.withInstituicaoRemetente(remetente)
				.withInstituicaoDestinataria(destinatario)
				.build();
		layoutEntrada = salvar(layoutEntrada);
		LayoutSaida layoutSaida = new LayoutSaidaBuilder().whithLayoutEntrada(layoutEntrada).build();

		SaidaDTO saidaDTO = new SaidaDTO(entradaDTO.getLinha(), layoutSaida.toString());

		return saidaDTO;
	}

}
