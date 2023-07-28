package com.devsuperior.dslearnbds.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;

/**
 * Essa classe de serviço fornece funcionalidades para trabalhar com entidades de Usuário.
 * Ela implementa a interface UserDetailsService para lidar com autenticação e autorização de usuário
 * usando o Spring Security.
 */
@Service
public class UserService implements UserDetailsService {

	// Cria um logger para registrar e exibir mensagens de log
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthService authService;
	
	/**
	 * Encontra um usuário pelo seu ID e retorna a representação DTO correspondente.
	 * Se o usuário não existir ou o usuário atual não tiver autorização para acessá-lo, uma exceção é lançada.
	 * 
	 * @param id O ID do usuário a ser encontrado.
	 * @return A representação UserDTO do usuário encontrado.
	 * @throws ResourceNotFoundException Se o usuário com o ID fornecido não for encontrado.
	 */
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		// Valida se o usuário atual está autorizado a acessar essa informação
		authService.validateSelfOrAdmin(id);
		// se ocorrer uma excessão , n executa o restante da funções
		
		// Encontra o usuário pelo ID no repositório
		Optional<User> obj = repository.findById(id);
		
		// Se o usuário não for encontrado, lança uma exceção ResourceNotFoundException
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		
		// Converte a entidade User em UserDTO e retorna
		return new UserDTO(entity);
	}
	
	/**
	 * Carrega um usuário pelo seu nome de usuário (e-mail) para fins de autenticação e autorização.
	 * 
	 * @param username O nome de usuário (e-mail) do usuário a ser carregado.
	 * @return A representação UserDetails do usuário encontrado.
	 * @throws UsernameNotFoundException Se o usuário com o nome de usuário fornecido não for encontrado.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Encontra o usuário pelo e-mail (nome de usuário) no repositório
		User user = repository.findByEmail(username);
		
		// Se o usuário não for encontrado, lança uma UsernameNotFoundException
		if (user == null) {
			logger.error("Usuário não encontrado: " + username);
			throw new UsernameNotFoundException("E-mail não encontrado");
		}
		
		// Registra a localização bem-sucedida do usuário
		logger.info("Usuário encontrado: " + username);
		
		// Retorna o usuário encontrado para autenticação e autorização
		return user;
	}
}
