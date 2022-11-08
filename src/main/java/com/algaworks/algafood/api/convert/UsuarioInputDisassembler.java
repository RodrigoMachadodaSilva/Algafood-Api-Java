package com.algaworks.algafood.api.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.dto.input.UsuarioModelInput;
import com.algaworks.algafood.domain.model.Usuario;

@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Usuario toDomainObject(UsuarioModelInput usuarioModelInput) {
		return modelMapper.map(usuarioModelInput, Usuario.class);
	}

	public void copyToDomainObject(UsuarioModelInput usuarioModelInput, Usuario usuario) {
		modelMapper.map(usuarioModelInput, usuario);
	}
}
