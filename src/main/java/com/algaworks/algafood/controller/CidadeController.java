package com.algaworks.algafood.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.convert.CidadeInputDisassembler;
import com.algaworks.algafood.api.convert.CidadeModelAssembler;
import com.algaworks.algafood.api.dto.input.CidadeInput;
import com.algaworks.algafood.api.dto.model.CidadeModel;
import com.algaworks.algafood.domain.Exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.Exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidadeService;

	@Autowired
	private CidadeModelAssembler cidadeModelAssembler;

	@Autowired
	private CidadeInputDisassembler cidadeInputDisassembler;

	@GetMapping
	public List<CidadeModel> listar() {
		List<Cidade> todasCidades = cidadeRepository.findAll();
		return cidadeModelAssembler.toCollectionModel(todasCidades);
	}

	@GetMapping("/{cidadeId}")
	public CidadeModel buscar(@PathVariable Long cidadeId) {
		try {

			Cidade cidade = cadastroCidadeService.buscar(cidadeId);

			return cidadeModelAssembler.toModel(cidade);

		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
		try {
			Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);

			cidade = cadastroCidadeService.salvar(cidade);

			return cidadeModelAssembler.toModel(cidade);

		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());

		}

	}

	@PutMapping("/{cidadeId}")
	public CidadeModel atualizar(@PathVariable @Valid Long cidadeId, @RequestBody CidadeInput cidadeInput) {

		try {

			Cidade cidadeAtual = cadastroCidadeService.buscar(cidadeId);

			cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeAtual);

			cidadeAtual = cadastroCidadeService.salvar(cidadeAtual);

			return cidadeModelAssembler.toModel(cidadeAtual);

		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}

	}

	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(Long cidadeId) {
		cadastroCidadeService.excluir(cidadeId);
	}

}
