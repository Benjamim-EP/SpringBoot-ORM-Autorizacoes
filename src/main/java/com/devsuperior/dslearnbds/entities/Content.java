package com.devsuperior.dslearnbds.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A classe Content representa o conteúdo de uma lição em um sistema de ensino.
 * Ela herda características da classe Lesson e é mapeada como uma entidade no banco de dados.
 */
@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
	private static final long serialVersionUID = 1L;

	// Conteúdo de texto que faz parte do conteúdo da lição
	private String textContent;
	
	// URI (Uniform Resource Identifier) do vídeo relacionado a esta lição
	private String videoUri;
	
	/**
	 * Construtor padrão sem argumentos.
	 */
	public Content() {
	}

	/**
	 * Construtor com argumentos para criar um novo objeto Content.
	 *
	 * @param id O identificador único do conteúdo.
	 * @param title O título do conteúdo.
	 * @param position A posição do conteúdo na sequência da seção.
	 * @param section A seção à qual este conteúdo pertence.
	 * @param textContent O conteúdo de texto associado a esta lição.
	 * @param videoUri A URI do vídeo relacionado a esta lição.
	 */
	public Content(Long id, String title, Integer position, Section section, String textContent, String videoUri) {
		// Chamando o construtor da superclasse Lesson para inicializar seus atributos.
		super(id, title, position, section);
		
		// Inicializando os atributos específicos desta classe.
		this.textContent = textContent;
		this.videoUri = videoUri;
	}

	/**
	 * Obtém o conteúdo de texto associado a esta lição.
	 *
	 * @return O conteúdo de texto associado a esta lição.
	 */
	public String getTextContent() {
		return textContent;
	}

	/**
	 * Define o conteúdo de texto associado a esta lição.
	 *
	 * @param textContent O novo conteúdo de texto a ser associado a esta lição.
	 */
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	/**
	 * Obtém a URI do vídeo relacionado a esta lição.
	 *
	 * @return A URI do vídeo relacionado a esta lição.
	 */
	public String getVideoUri() {
		return videoUri;
	}

	/**
	 * Define a URI do vídeo relacionado a esta lição.
	 *
	 * @param videoUri A nova URI do vídeo a ser associado a esta lição.
	 */
	public void setVideoUri(String videoUri) {
		this.videoUri = videoUri;
	}
}
