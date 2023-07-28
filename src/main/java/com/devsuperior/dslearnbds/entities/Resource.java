package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.enums.ResourceType;

/**
 * Esta classe representa a entidade Resource, que corresponde a um recurso de aprendizagem dentro da aplicação.
 * Cada recurso pode estar associado a uma Oferta (Offer) e pode pertencer a várias Seções (Section).
 */
@Entity
@Table(name = "tb_resource")
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceType type;

    // Muitos recursos podem pertencer a uma oferta (Offer)
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    // Um recurso pode estar vinculado a várias seções (Section)
    @OneToMany(mappedBy = "resource")
    private List<Section> sections = new ArrayList<>();

    /**
     * Construtor padrão para a entidade Resource.
     */
    public Resource() {
    }

    /**
     * Construtor com parâmetros para a entidade Resource.
     *
     * @param id          O identificador único do recurso.
     * @param title       O título do recurso.
     * @param description A descrição do recurso.
     * @param position    A posição/ordem do recurso dentro da oferta associada.
     * @param imgUri      A URI da imagem associada ao recurso.
     * @param type        O tipo do recurso (por exemplo, Vídeo, PDF, Quiz).
     * @param offer       A oferta à qual esse recurso pertence.
     */
    public Resource(Long id, String title, String description, Integer position, String imgUri, ResourceType type,
                    Offer offer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.imgUri = imgUri;
        this.type = type;
        this.offer = offer;
    }

    // Getters e Setters para os atributos do recurso

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

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    /**
     * Sobrescreve o método hashCode para comparar recursos com base em seus IDs.
     *
     * @return O código hash calculado para este recurso.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Sobrescreve o método equals para verificar se dois recursos são iguais com base em seus IDs.
     *
     * @param obj O outro objeto a ser comparado.
     * @return True se os dois recursos forem iguais (tiverem o mesmo ID), caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resource other = (Resource) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}

