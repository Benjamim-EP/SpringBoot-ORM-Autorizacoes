package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.services.DeliverService;

/**
 * Classe que representa o recurso REST para as operações relacionadas a entregas (Deliveries).
 */
@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    // Injeção de dependência do serviço DeliverService usando a anotação @Autowired.
	@Autowired
	private DeliverService service;
	
	/**
	 * Método que atualiza uma revisão de entrega com base nos dados fornecidos.
	 * 
	 * @param id Identificador da entrega que terá a revisão atualizada.
	 * @param dto DTO (Data Transfer Object) contendo os dados da revisão a serem atualizados.
	 * @return ResponseEntity com status HTTP 204 (No Content) em caso de sucesso na atualização da revisão.
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto) {
		service.saveRevision(id, dto);
		return ResponseEntity.noContent().build();
	}
}
