package com.algaworks.algafood.api;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.model.input.RestauranteInput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class RestauranteModelDisasssembler {

	private ModelMapper modelMapper;

	public Restaurante toDomainObject(RestauranteInput restauranteInput) {
		return modelMapper.map(restauranteInput, Restaurante.class);
	}

	public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {

		// Para evitar org.hibernate.HibernateException: identifier of an an instance of
		// com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2
		restaurante.setCozinha(new Cozinha());

		modelMapper.map(restauranteInput, restaurante);
	}

}
