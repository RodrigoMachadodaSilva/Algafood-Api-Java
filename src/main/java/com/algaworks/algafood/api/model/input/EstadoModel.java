package com.algaworks.algafood.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoModel {

	private Long id;
	private String nome;
	private EstadoModel estado;
}
