package com.algaworks.algafood.api.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.dto.input.GrupoModelInput;
import com.algaworks.algafood.domain.model.Grupo;

@Component
public class GrupoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Grupo toDomainObject(GrupoModelInput grupoModelInput) {
		return modelMapper.map(grupoModelInput, Grupo.class);
	}

	public void copyToDomainObject(GrupoModelInput grupoModelInput, Grupo grupo) {
		modelMapper.map(grupoModelInput, grupo);
	}

}
