package com.algaworks.algafood.api.dto.model;

import java.util.HashSet;
import java.util.Set;

import com.algaworks.algafood.domain.model.Grupo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioModel {

	private Long id;
	private String nome;
	private String email;private Set<Grupo> grupos = new HashSet<>();
	
}
