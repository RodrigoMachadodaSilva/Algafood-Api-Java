package com.algaworks.algafood.domain.model.mixin;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class CozinhaMixIn {
	
	@JsonIgnore
	private List<Restaurante> restaurantes = new ArrayList<>();

}
