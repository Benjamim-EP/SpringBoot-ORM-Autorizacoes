package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

    // Injeção de dependência do repositório de usuários
    @Autowired
    private UserRepository userRepository;

    /**
     * Método para obter o usuário autenticado no sistema.
     * 
     * @return O usuário autenticado no sistema.
     * @throws UnauthorizedException se a autenticação falhar ou não houver um usuário autenticado.
     */
    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            // Obtém o nome de usuário (email) do usuário autenticado atualmente no contexto de segurança
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            // Busca e retorna o usuário com o email correspondente
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            // Lança uma exceção personalizada caso ocorra algum erro na busca do usuário autenticado
            throw new UnauthorizedException("Invalid user");
        }
    }

	/**
     * Valida se o usuário autenticado é o próprio usuário ou um administrador.
     * 
     * @param userId O ID do usuário a ser validado.
     * @throws ForbiddenException se o usuário autenticado não for o próprio usuário nem um administrador.
     */
	public void validateSelfOrAdmin(Long userId) {
		// Obtém o usuário autenticado no sistema
		User user = authenticated();

		// Verifica se o ID do usuário autenticado é igual ao ID do usuário que está sendo validado,
        // ou se o usuário autenticado possui a função (ROLE) de administrador.
        // Caso nenhuma das condições seja verdadeira, lança uma exceção indicando acesso negado.
        
		if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access denied");
		}
	}
}
