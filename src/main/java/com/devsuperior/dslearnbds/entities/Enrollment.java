package com.devsuperior.dslearnbds.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

/**
 * Classe que representa a entidade de Matrícula em um curso (Enrollment) no sistema.
 */
@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK();
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMoment;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;

	@ManyToMany(mappedBy = "enrollmentsDone")
	private Set<Lesson> lessonsDone = new HashSet<>();
	
	@OneToMany(mappedBy = "enrollment")
	private List<Deliver> deliveries = new ArrayList<>();
	
	/**
	 * Construtor padrão sem argumentos.
	 */
	public Enrollment() {
	}

	/**
	 * Construtor com argumentos para criar uma nova matrícula.
	 *
	 * @param user O usuário (aluno) associado à matrícula.
	 * @param offer A oferta (curso) associada à matrícula.
	 * @param enrollMoment O momento da matrícula.
	 * @param refundMoment O momento do reembolso da matrícula.
	 * @param available Indica se a matrícula está disponível.
	 * @param onlyUpdate Indica se a matrícula é apenas para atualização.
	 */
	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		super();
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	/**
	 * Obtém o estudante (usuário/aluno) associado à matrícula.
	 *
	 * @return O estudante associado à matrícula.
	 */
	public User getStudent() {
		return id.getUser();
	}
	
	/**
	 * Define o estudante (usuário/aluno) associado à matrícula.
	 *
	 * @param user O estudante a ser associado à matrícula.
	 */
	public void setStudent(User user) {
		id.setUser(user);
	}

	/**
	 * Obtém a oferta (curso) associada à matrícula.
	 *
	 * @return A oferta associada à matrícula.
	 */
	public Offer getOffer() {
		return id.getOffer();
	}
	
	/**
	 * Define a oferta (curso) associada à matrícula.
	 *
	 * @param offer A oferta a ser associada à matrícula.
	 */
	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}
	
	/**
	 * Obtém o momento da matrícula.
	 *
	 * @return O momento da matrícula.
	 */
	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	/**
	 * Define o momento da matrícula.
	 *
	 * @param enrollMoment O momento da matrícula a ser definido.
	 */
	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	/**
	 * Obtém o momento do reembolso da matrícula.
	 *
	 * @return O momento do reembolso da matrícula.
	 */
	public Instant getRefundMoment() {
		return refundMoment;
	}

	/**
	 * Define o momento do reembolso da matrícula.
	 *
	 * @param refundMoment O momento do reembolso a ser definido.
	 */
	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	/**
	 * Verifica se a matrícula está disponível.
	 *
	 * @return true se a matrícula está disponível, false caso contrário.
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Define a disponibilidade da matrícula.
	 *
	 * @param available A disponibilidade a ser definida.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Verifica se a matrícula é apenas para atualização.
	 *
	 * @return true se a matrícula é apenas para atualização, false caso contrário.
	 */
	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	/**
	 * Define se a matrícula é apenas para atualização.
	 *
	 * @param onlyUpdate Indica se a matrícula é apenas para atualização.
	 */
	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	/**
	 * Obtém a lista de entregas associadas à matrícula.
	 *
	 * @return A lista de entregas associadas à matrícula.
	 */
	public List<Deliver> getDeliveries() {
		return deliveries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollment other = (Enrollment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
