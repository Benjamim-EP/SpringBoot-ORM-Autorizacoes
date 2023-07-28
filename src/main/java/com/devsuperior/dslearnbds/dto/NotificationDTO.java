/*
 * Esta classe representa um Objeto de Transferência de Dados (DTO) para a entidade de Notificação.
 * Um DTO é usado para transferir dados entre diferentes camadas da aplicação,
 * neste caso, entre a camada de serviço e a camada de controle (controller).
 */
package com.devsuperior.dslearnbds.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dslearnbds.entities.Notification;

public class NotificationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos que representam as propriedades de uma notificação
    private Long id;
    private String text;
    private Instant moment;
    private boolean read;
    private String route;
    private Long userId;

    // Construtor vazio para permitir a criação sem argumentos
    public NotificationDTO() {
    }

    /*
     * Construtor com parâmetros para criar um objeto NotificationDTO com valores especificados.
     *
     * @param id      O identificador único da notificação.
     * @param text    O conteúdo de texto da notificação.
     * @param moment  A data e hora em que a notificação foi criada.
     * @param read    Um booleano indicando se a notificação foi lida ou não.
     * @param route   A rota para navegar quando a notificação é clicada.
     * @param userId  O identificador único do usuário associado à notificação.
     */
    public NotificationDTO(Long id, String text, Instant moment, boolean read, String route, Long userId) {
        this.id = id;
        this.text = text;
        this.moment = moment;
        this.read = read;
        this.route = route;
        this.userId = userId;
    }

    /*
     * Construtor para criar um objeto NotificationDTO a partir de uma entidade Notification.
     *
     * @param entity  A entidade de Notificação a partir da qual criar o objeto DTO.
     */
    public NotificationDTO(Notification entity) {
        // Extração de valores da entidade Notification e atribuição a atributos do DTO
        id = entity.getId();
        text = entity.getText();
        moment = entity.getMoment();
        read = entity.isRead();
        route = entity.getRoute();
        userId = entity.getUser().getId();
    }

    // Getters e setters para todos os atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
