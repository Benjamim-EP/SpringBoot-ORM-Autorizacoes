/**
 * Esta classe representa a chave primária para a entidade Enrollment.
 * Ela é incorporada na entidade Enrollment para definir uma chave primária composta
 * que consiste nas entidades User e Offer.
 */
package com.devsuperior.dslearnbds.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.devsuperior.dslearnbds.entities.Offer;
import com.devsuperior.dslearnbds.entities.User;

@Embeddable
public class EnrollmentPK implements Serializable {
    private static final long serialVersionUID = 1L;

    // Entidade User a ser associada a esta matrícula
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Entidade Offer a ser associada a esta matrícula
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    /**
     * Construtor padrão.
     * Inicializa um objeto EnrollmentPK vazio.
     */
    public EnrollmentPK() {
    }

    /**
     * Construtor com parâmetros.
     * Inicializa um objeto EnrollmentPK com as entidades User e Offer fornecidas.
     *
     * @param user  A entidade User associada a esta matrícula.
     * @param offer A entidade Offer associada a esta matrícula.
     */
    public EnrollmentPK(User user, Offer offer) {
        this.user = user;
        this.offer = offer;
    }

    /**
     * Obtém a entidade User associada a esta matrícula.
     *
     * @return A entidade User associada a esta matrícula.
     */
    public User getUser() {
        return user;
    }

    /**
     * Define a entidade User associada a esta matrícula.
     *
     * @param user A entidade User a ser associada a esta matrícula.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Obtém a entidade Offer associada a esta matrícula.
     *
     * @return A entidade Offer associada a esta matrícula.
     */
    public Offer getOffer() {
        return offer;
    }

    /**
     * Define a entidade Offer associada a esta matrícula.
     *
     * @param offer A entidade Offer a ser associada a esta matrícula.
     */
    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    /**
     * Gera um código hash para este objeto EnrollmentPK.
     *
     * @return O código hash para este objeto EnrollmentPK.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((offer == null) ? 0 : offer.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    /**
     * Compara este objeto EnrollmentPK com outro objeto para verificar a igualdade.
     *
     * @param obj O objeto a ser comparado com este objeto EnrollmentPK.
     * @return True se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnrollmentPK other = (EnrollmentPK) obj;
        if (offer == null) {
            if (other.offer != null)
                return false;
        } else if (!offer.equals(other.offer))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}
