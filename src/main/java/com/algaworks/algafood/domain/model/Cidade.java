package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.ConvertGroup;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.algaworks.algafood.Groups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@ConvertGroup(from = DEFAULT.class, to = Groups.EstadoId.class)
	@Valid
	@ManyToOne
	@NotBlank
	@JoinColumn(nullable = false)
	private Estado estado;

}
