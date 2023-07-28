package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A classe Lesson é uma entidade abstrata que representa uma lição ou aula dentro do sistema.
 * Ela é a classe pai de outras classes que representam tipos específicos de lições.
 * A estratégia de herança utilizada é JOINED, onde subclasses têm suas próprias tabelas no banco de dados,
 * e as consultas em subclasses são unidas com as consultas da classe pai usando JOIN.
 */
@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	
	@OneToMany(mappedBy = "lesson")
	private List<Deliver> deliveries = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "tb_lessons_done",
		joinColumns = @JoinColumn(name = "lesson_id"),
		inverseJoinColumns = {
				@JoinColumn(name = "user_id"),
				@JoinColumn(name = "offer_id")
		}
	)
	private Set<Enrollment> enrollmentsDone = new HashSet<>();
	
	/**
	 * Construtor padrão da classe Lesson.
	 */
	public Lesson() {
	}

	/**
	 * Construtor com argumentos da classe Lesson.
	 *
	 * @param id       O ID da lição.
	 * @param title    O título da lição.
	 * @param position A posição da lição dentro de uma seção.
	 * @param section  A seção à qual a lição pertence.
	 */
	public Lesson(Long id, String title, Integer position, Section section) {
		super();
		this.id = id;
		this.title = title;
		this.position = position;
		this.section = section;
	}

	// Getters e Setters

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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Set<Enrollment> getEnrollmentsDone() {
		return enrollmentsDone;
	}

	public List<Deliver> getDeliveries() {
		return deliveries;
	}

	// Equals e HashCode

	/**
	 * Este método calcula o código hash para um objeto da classe Lesson.
	 * O código hash é usado para uma rápida recuperação de objetos em coleções baseadas em hash, como HashMap, HashSet, etc.
	 * Ele leva em consideração o campo 'id' do objeto Lesson para gerar o código hash.
	 *
	 * @return O valor do código hash para este objeto Lesson.
	 */
	@Override
	public int hashCode() {
		final int primo = 31; // Um número primo usado para gerar um bom código hash
		int resultado = 1; // Inicializa o resultado com um número primo arbitrário

		// Se o campo 'id' não for nulo, calcula o seu código hash e o incorpora ao resultado
		resultado = primo * resultado + ((id == null) ? 0 : id.hashCode());

		return resultado; // Retorna o valor final do código hash
	}

	/**
	 * Este método verifica se um objeto é igual ao objeto Lesson atual.
	 * Dois objetos Lesson são considerados iguais se tiverem o mesmo valor no campo 'id'.
	 *
	 * @param obj O objeto a ser comparado com o objeto Lesson atual.
	 * @return True se os objetos forem iguais, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; // Se ambos os objetos apontarem para a mesma localização de memória, eles são iguais.

		if (obj == null)
			return false; // Se o objeto comparado for nulo, eles não podem ser iguais.

		if (getClass() != obj.getClass())
			return false; // Se as classes dos dois objetos forem diferentes, eles não são iguais.

		Lesson outro = (Lesson) obj; // Faz o cast do objeto comparado para um objeto Lesson.

		// Se o campo 'id' do objeto Lesson atual for nulo
		if (id == null) {
			// Se o campo 'id' do outro objeto Lesson não for nulo, eles não são iguais.
			if (outro.id != null)
				return false;
		} else {
			// Se ambos os campos 'id' não forem nulos, verifica se têm o mesmo valor.
			// Se forem diferentes, os objetos não são iguais.
			if (!id.equals(outro.id))
				return false;
		}

		return true; // Os objetos têm o mesmo valor no campo 'id', então eles são iguais.
	}
}
