package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa a entidade Section do sistema DS Learn.
 * Uma Section representa uma seção de um recurso de aprendizado, podendo ter um pré-requisito.
 */
@Entity
@Table(name = "tb_section")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador único da seção.

	private String title; // Título da seção.

	private String description; // Descrição da seção.

	private Integer position; // Posição da seção no fluxo do recurso.

	private String imgUri; // URI da imagem associada à seção, caso exista.

	@ManyToOne
	@JoinColumn(name = "resource_id")
	private Resource resource; // Recurso de aprendizado associado à seção.

	@ManyToOne
	@JoinColumn(name = "prerequisite_id")
	private Section prerequisite; // Seção pré-requisito, caso exista.

	/**
	 * Construtor padrão sem argumentos.
	 */
	public Section() {
	}

	/**
	 * Construtor com argumentos para criar uma nova instância de Section.
	 * 
	 * @param id          Identificador único da seção.
	 * @param title       Título da seção.
	 * @param description Descrição da seção.
	 * @param position    Posição da seção no fluxo do recurso.
	 * @param imgUri      URI da imagem associada à seção, caso exista.
	 * @param resource    Recurso de aprendizado associado à seção.
	 * @param prerequisite Seção pré-requisito, caso exista.
	 */
	public Section(Long id, String title, String description, Integer position, String imgUri, Resource resource,
			Section prerequisite) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.position = position;
		this.imgUri = imgUri;
		this.resource = resource;
		this.prerequisite = prerequisite;
	}

	// Getters e Setters abaixo:

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Section getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(Section prerequisite) {
		this.prerequisite = prerequisite;
	}

	/**
	 * Método que calcula o código hash para a seção, utilizando apenas o atributo id.
	 * Esse método é necessário para o correto funcionamento de algumas estruturas de dados em Java.
	 *
	 * @return O código hash calculado.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Método que verifica se a seção é igual a outro objeto, comparando apenas o atributo id.
	 * Esse método é necessário para o correto funcionamento de algumas estruturas de dados em Java.
	 *
	 * @param obj O objeto a ser comparado com a seção.
	 * @return true se os objetos forem iguais (mesmo id), false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
