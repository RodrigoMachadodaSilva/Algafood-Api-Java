package com.algaworks.algafood.api.dto.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.StatusPedido;
import com.algaworks.algafood.domain.model.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoModel {

	private Long id;

	private BigDecimal subtotal;

	private BigDecimal taxaFrete;

	private BigDecimal valorTotal;

	private Endereco enderecoEntrega;

	private StatusPedido status;

	private OffsetDateTime dataCriacao;

	private OffsetDateTime dataConfirmacao;

	private OffsetDateTime dataCancelamento;

	private OffsetDateTime dataEntrega;

	private FormaPagamento formaPagamento;

	private RestauranteModel restaurante;

	private Usuario cliente;

	private List<ItemPedidoModel> itens;

}
