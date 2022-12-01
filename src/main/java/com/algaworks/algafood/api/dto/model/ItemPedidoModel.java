package com.algaworks.algafood.api.dto.model;

import java.math.BigDecimal;

import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoModel {

	private Long id;

	private BigDecimal precoUnitario;

	private BigDecimal precoTotal;

	private Integer quantidade;

	private String observacao;

	private Pedido pedido;

	private Produto produto;

}
