package com.algaworks.algafood.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.algaworks.algafood.api.convert.RestauranteModelAssembler;
import com.algaworks.algafood.api.convert.RestauranteModelDisasssembler;
import com.algaworks.algafood.api.dto.input.RestauranteInput;
import com.algaworks.algafood.api.dto.model.RestauranteModel;
import com.algaworks.algafood.domain.Exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.Exception.NegocioException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;

	@Autowired
	private RestauranteModelAssembler restauranteModelAssembler;

	@Autowired
	private RestauranteModelDisasssembler restauranteModelDisasssembler;

	@GetMapping
	public List<RestauranteModel> listar() {
		return restauranteModelAssembler.toCollectionModel(restauranteRepository.findAll());
	}

	@GetMapping("/{restauranteId}")
	public RestauranteModel buscar(@PathVariable Long restauranteId) {
		return restauranteModelAssembler.toModel(cadastroRestauranteService.buscar(restauranteId));

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RestauranteModel salvar(@RequestBody @Valid RestauranteInput restauranteInput) {
		try {

			Restaurante restaurante = restauranteModelDisasssembler.toDomainObject(restauranteInput);

			return restauranteModelAssembler.toModel(cadastroRestauranteService.salvar(restaurante));

		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());

		}

	}

	@PutMapping("/{restauranteId}")
	public RestauranteModel atualizar(@PathVariable Long restauranteId,
			@RequestBody RestauranteInput restauranteInput) {

		// Restaurante restaurante =
		// restauranteModelDisasssembler.toDomainObject(restauranteInput);

		Restaurante restauranteAtual = cadastroRestauranteService.buscar(restauranteId);

		restauranteModelDisasssembler.copyToDomainObject(restauranteInput, restauranteAtual);

		// BeanUtils.copyProperties(restaurante, restauranteAtual, "id",
		// "formasPagamento", "endereco", "produtos");

		return restauranteModelAssembler.toModel(cadastroRestauranteService.salvar(restauranteAtual));
	}

	@PostMapping("/{restauranteId}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void ativar(@PathVariable Long restauranteId) {
		cadastroRestauranteService.ativar(restauranteId);
	}

	@DeleteMapping("/{restauranteId}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativar(@PathVariable Long restauranteId) {
		cadastroRestauranteService.inativar(restauranteId);
	}
	
	@PutMapping("/{restauranteId}/abertura")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void abrir(@PathVariable Long restauranteId) {
	    cadastroRestauranteService.abrirRestaurante(restauranteId);
	}

	@PutMapping("/{restauranteId}/fechamento")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void fechar(@PathVariable Long restauranteId) {
	    cadastroRestauranteService.fecharRestaurante(restauranteId);
	} 

}
