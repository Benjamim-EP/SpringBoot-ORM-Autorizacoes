package com.devsuperior.dslearnbds.dto;

import java.io.Serializable;

import com.devsuperior.dslearnbds.entities.enums.DeliverStatus;

/**
 * A classe DeliverRevisionDTO representa o objeto de transferência de dados para revisão de entrega.
 * Ela contém informações sobre o status, feedback e a contagem de respostas corretas.
 */
public class DeliverRevisionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    // O status da revisão de entrega.
    private DeliverStatus status;

    // O feedback fornecido para a revisão de entrega.
    private String feedback;

    // A contagem de respostas corretas na revisão de entrega.
    private Integer correctCount;
    
    /**
     * Construtor padrão da classe DeliverRevisionDTO.
     * Cria um objeto DeliverRevisionDTO vazio.
     */
    public DeliverRevisionDTO() {
    }

    /**
     * Construtor parametrizado da classe DeliverRevisionDTO.
     * Cria um objeto DeliverRevisionDTO com os dados especificados.
     * 
     * @param status O status da revisão de entrega.
     * @param feedback O feedback fornecido para a revisão de entrega.
     * @param correctCount A contagem de respostas corretas na revisão de entrega.
     */
    public DeliverRevisionDTO(DeliverStatus status, String feedback, Integer correctCount) {
        super();
        this.status = status;
        this.feedback = feedback;
        this.correctCount = correctCount;
    }

    /**
     * Obtém o status da revisão de entrega.
     * 
     * @return O status da revisão de entrega.
     */
    public DeliverStatus getStatus() {
        return status;
    }

    /**
     * Define o status da revisão de entrega.
     * 
     * @param status O status da revisão de entrega a ser definido.
     */
    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    /**
     * Obtém o feedback fornecido para a revisão de entrega.
     * 
     * @return O feedback da revisão de entrega.
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Define o feedback para a revisão de entrega.
     * 
     * @param feedback O feedback da revisão de entrega a ser definido.
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Obtém a contagem de respostas corretas na revisão de entrega.
     * 
     * @return A contagem de respostas corretas.
     */
    public Integer getCorrectCount() {
        return correctCount;
    }

    /**
     * Define a contagem de respostas corretas na revisão de entrega.
     * 
     * @param correctCount A contagem de respostas corretas a ser definida.
     */
    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }
}
