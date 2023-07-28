package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A classe Offer representa uma oferta de curso.
 * 
 * Esta classe é uma entidade JPA, mapeada para a tabela "tb_offer" no banco de dados.
 * Ela contém informações sobre a oferta, como a edição, momento de início e término,
 * o curso associado e os recursos e tópicos relacionados.
 */
@Entity
@Table(name = "tb_offer")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String edition;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant startMoment;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant endMoment;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@OneToMany(mappedBy = "offer")
	private List<Resource> resources = new ArrayList<>();
	
	@OneToMany(mappedBy = "offer")
	private List<Topic> topics = new ArrayList<>();	
	
	/**
	 * Construtor padrão da classe Offer.
	 * Cria uma nova instância de Offer com valores padrão para seus atributos.
	 */
	public Offer() {
	}

	/**
	 * Construtor da classe Offer com parâmetros.
	 * Cria uma nova instância de Offer com os valores fornecidos para seus atributos.
	 * 
	 * @param id O identificador único da oferta.
	 * @param edition A edição da oferta.
	 * @param startMoment O momento de início da oferta.
	 * @param endMoment O momento de término da oferta.
	 * @param course O curso associado à oferta.
	 */
	public Offer(Long id, String edition, Instant startMoment, Instant endMoment, Course course) {
		super();
		this.id = id;
		this.edition = edition;
		this.startMoment = startMoment;
		this.endMoment = endMoment;
		this.course = course;
	}

	// Getters e Setters para os atributos da classe
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Instant getStartMoment() {
		return startMoment;
	}

	public void setStartMoment(Instant startMoment) {
		this.startMoment = startMoment;
	}

	public Instant getEndMoment() {
		return endMoment;
	}

	public void setEndMoment(Instant endMoment) {
		this.endMoment = endMoment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public List<Resource> getResources() {
		return resources;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	/**
	 * Calcula e retorna o código hash para a instância da oferta com base no seu identificador único (id).
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
	 * Verifica se esta instância da oferta é igual a outra instância, comparando seus identificadores únicos (id).
	 * 
	 * @param obj O objeto a ser comparado.
	 * @return true se os objetos são iguais, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
