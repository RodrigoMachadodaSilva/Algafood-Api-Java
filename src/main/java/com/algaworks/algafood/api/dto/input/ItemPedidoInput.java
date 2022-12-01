package com.algaworks.algafood.api.dto.input;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Produto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoInput {
	
    @EqualsAndHashCode.Include
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private Integer quantidade;
    private String observacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;


}
