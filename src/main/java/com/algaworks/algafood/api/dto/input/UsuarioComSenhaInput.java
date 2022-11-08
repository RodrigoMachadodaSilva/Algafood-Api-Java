package com.algaworks.algafood.api.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioComSenhaInput extends UsuarioModelInput {

    @NotBlank
    private String senha;
}
