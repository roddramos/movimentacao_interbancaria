package com.accesstage.movimentacao_interbancaria.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accesstage.movimentacao_interbancaria.dto.EntradaDTO;
import com.accesstage.movimentacao_interbancaria.dto.SaidaDTO;
import com.accesstage.movimentacao_interbancaria.layout.LayoutEntrada;
import com.accesstage.movimentacao_interbancaria.layout.LayoutSaida;
import com.accesstage.movimentacao_interbancaria.layout.LayoutSaidaBuilder;
import com.accesstage.movimentacao_interbancaria.service.LayoutEntradaService;

@RestController
@RequestMapping(value = "api/movimentacao")
public class MovimentacaoResources {

	@Autowired
	private LayoutEntradaService layoutEntradaService;

	@RequestMapping(value = "/{remetente}/{destinatario}/unique", method = RequestMethod.POST)
	public ResponseEntity<SaidaDTO> receiveUnique(@PathVariable("remetente") String remetente,
			@PathVariable("destinatario") String destinatario, @RequestBody @Valid EntradaDTO entradaUnicaDTO) {

		SaidaDTO saidaDTO = layoutEntradaService.tratar(remetente, destinatario, entradaUnicaDTO);

		return ResponseEntity.ok(saidaDTO);
	}

	@RequestMapping(value = "/{remetente}/{destinatario}/many", method = RequestMethod.POST)
	public ResponseEntity<List<SaidaDTO>> receiveMany(@PathVariable("remetente") String remetente,
			@PathVariable("destinatario") String destinatario, @RequestBody List<EntradaDTO> listEntradaUnicaDTO) {

		listEntradaUnicaDTO.stream().forEach(entradaUnicaDTO -> {
			Validate.validState(entradaUnicaDTO.getLinha().length() == 69, entradaUnicaDTO.toString()
					+ " -> Linha não corresponde ao layout de entrada. Necessário 69 caracteres");

		});

		List<SaidaDTO> saidaDTO = listEntradaUnicaDTO.stream().map(entradaUnicaDTO -> {
			return layoutEntradaService.tratar(remetente, destinatario, entradaUnicaDTO);
		}).collect(Collectors.toList());

		return ResponseEntity.ok(saidaDTO);
	}

	@RequestMapping(value = "/{remetente}/entrada", method = RequestMethod.GET)
	public ResponseEntity<List<LayoutEntrada>> buscaTodasPorRemetenteEntrada(
			@PathVariable("remetente") String remetente) {
		return ResponseEntity.ok(layoutEntradaService.buscaPorInstituicaoRemetente(remetente));
	}

	@RequestMapping(value = "/{remetente}/saida", method = RequestMethod.GET)
	public ResponseEntity<List<LayoutSaida>> buscaTodasPorRemetenteSaida(@PathVariable("remetente") String remetente) {
		List<LayoutEntrada> buscaPorInstituicaoRemetente = layoutEntradaService.buscaPorInstituicaoRemetente(remetente);

		List<LayoutSaida> collect = buscaPorInstituicaoRemetente.stream().map(entrada -> {
			return new LayoutSaidaBuilder().whithLayoutEntrada(entrada).build();
		}).collect(Collectors.toList());

		return ResponseEntity.ok(collect);
	}

	@RequestMapping(value = "/{remetente}/{destinatario}/entrada", method = RequestMethod.GET)
	public ResponseEntity<List<LayoutEntrada>> buscaTodasPorRemetenteDestinatarioEntrada(
			@PathVariable("remetente") String remetente, @PathVariable("destinatario") String destinatario) {
		return ResponseEntity.ok(layoutEntradaService.buscaPorInstituicaoDestinataria(remetente, destinatario));
	}

	@RequestMapping(value = "/{remetente}/{destinatario}/saida", method = RequestMethod.GET)
	public ResponseEntity<List<LayoutSaida>> buscaTodasPorRemetenteDestinatarioSaida(
			@PathVariable("remetente") String remetente, @PathVariable("destinatario") String destinatario) {
		List<LayoutEntrada> buscaPorInstituicaoRemetente = layoutEntradaService
				.buscaPorInstituicaoDestinataria(remetente, destinatario);

		List<LayoutSaida> collect = buscaPorInstituicaoRemetente.stream().map(entrada -> {
			return new LayoutSaidaBuilder().whithLayoutEntrada(entrada).build();
		}).collect(Collectors.toList());

		return ResponseEntity.ok(collect);
	}

}
