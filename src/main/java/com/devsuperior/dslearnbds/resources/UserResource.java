package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.services.UserService;

// Esta é a classe UserResource, que atua como o controlador da API REST para gerenciar operações relacionadas a usuários.

@RestController
@RequestMapping(value = "/users") // Essa anotação especifica o caminho base da URL para todos os endpoints deste controlador.
public class UserResource {

    @Autowired
    private UserService service; // Autowired é usado para injetar automaticamente uma instância de UserService nesta classe.

    /**
     * Endpoint GET para recuperar informações do usuário pelo ID.
     *
     * @param id O identificador único do usuário a ser recuperado.
     * @return ResponseEntity contendo um objeto UserDTO com informações do usuário e um código de status.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        // Chama o método findById de UserService para recuperar as informações do usuário.
        UserDTO dto = service.findById(id);
        // Retorna um ResponseEntity com o objeto UserDTO e um código de status OK (200) se a operação for bem-sucedida.
        return ResponseEntity.ok().body(dto);
    }
}
