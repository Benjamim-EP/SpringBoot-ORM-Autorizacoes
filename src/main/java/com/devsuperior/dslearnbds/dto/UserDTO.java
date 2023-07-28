/**
 * Esta classe representa um Objeto de Transferência de Dados (DTO) para a entidade Usuário.
 * É utilizada para transferir dados de usuário entre diferentes camadas da aplicação.
 */
package com.devsuperior.dslearnbds.dto;

import java.io.Serializable;

import com.devsuperior.dslearnbds.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	private Long id;        // ID do usuário
	private String name;    // Nome do usuário
	private String email;   // Endereço de e-mail do usuário
	
	// Construtores

	/**
	 * Construtor padrão sem parâmetros.
	 */
	public UserDTO() {
	}

	/**
	 * Construtor parametrizado para criar um objeto UserDTO com os dados fornecidos.
	 *
	 * @param id    O ID do usuário.
	 * @param name  O nome do usuário.
	 * @param email O endereço de e-mail do usuário.
	 */
	public UserDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	/**
	 * Construtor que recebe uma entidade de Usuário e extrai seus dados para criar um objeto UserDTO.
	 *
	 * @param entity A entidade de Usuário da qual os dados serão extraídos.
	 */
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	}

	// Getters e Setters

	/**
	 * Obtém o ID do usuário.
	 *
	 * @return O ID do usuário.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Define o ID do usuário.
	 *
	 * @param id O ID do usuário a ser definido.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtém o nome do usuário.
	 *
	 * @return O nome do usuário.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o nome do usuário.
	 *
	 * @param name O nome do usuário a ser definido.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtém o endereço de e-mail do usuário.
	 *
	 * @return O endereço de e-mail do usuário.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define o endereço de e-mail do usuário.
	 *
	 * @param email O endereço de e-mail do usuário a ser definido.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
