# README.md - API DSLearn Cap 4

Este é um documento README.md que descreve a estrutura e organização do projeto "Dslearnbds" relacionado ao Capítulo 4 do DSLearn, uma API desenvolvida com Spring Boot. O Capítulo 4 aborda os temas de Domínio, ORM (Object-Relational Mapping) e Autorizações. A API permite a autenticação de usuários e fornece endpoints relacionados a usuários, entregas (deliveries) e notificações.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
+---dslearnbds
¦   DslearnbdsApplication.java
¦   
+---components
¦       JwtTokenEnhancer.java
¦       
+---config
¦       AppConfig.java
¦       AuthorizationServerConfig.java
¦       ResourceServerConfig.java
¦       WebSecurityConfig.java
¦       
+---dto
¦       DeliverRevisionDTO.java
¦       NotificationDTO.java
¦       UserDTO.java
¦       
+---entities
¦   ¦   Content.java
¦   ¦   Course.java
¦   ¦   Deliver.java
¦   ¦   Enrollment.java
¦   ¦   Lesson.java
¦   ¦   Notification.java
¦   ¦   Offer.java
¦   ¦   Reply.java
¦   ¦   Resource.java
¦   ¦   Role.java
¦   ¦   Section.java
¦   ¦   Task.java
¦   ¦   Topic.java
¦   ¦   User.java
¦   ¦   
¦   +---enums
¦   ¦       DeliverStatus.java
¦   ¦       ResourceType.java
¦   ¦       
¦   +---pk
¦           EnrollmentPK.java
¦           
+---repositories
¦       CourseRepository.java
¦       DeliverRepository.java
¦       EnrollmentRepository.java
¦       LessonRepository.java
¦       NotificationRepository.java
¦       OfferRepository.java
¦       ReplyRepository.java
¦       ResourceRepository.java
¦       RoleRepository.java
¦       SectionRepository.java
¦       TopicRepository.java
¦       UserRepository.java
¦       
+---resources
¦   ¦   DeliverResource.java
¦   ¦   NotificationResource.java
¦   ¦   UserResource.java
¦   ¦   
¦   +---exceptions
¦           FieldMessage.java
¦           OAuthCustomError.java
¦           ResourceExceptionHandler.java
¦           StandardError.java
¦           ValidationError.java
¦           
+---services
        AuthService.java
        DeliverService.java
        NotificationService.java
        UserService.java
¦   
¦   +---exceptions
¦           DatabaseException.java
¦           ForbiddenException.java
¦           ResourceNotFoundException.java
¦           UnauthorizedException.java
```

## Descrição dos Pacotes

- **dslearnbds**: Pacote raiz do projeto Spring Boot.
- **components**: Contém componentes relacionados a melhorias no token JWT.
- **config**: Contém classes de configuração, como a configuração do servidor de autorização, servidor de recursos e segurança web.
- **dto**: Contém classes Data Transfer Object (DTO) para transferir dados entre a API e a camada de serviço.
- **entities**: Contém as classes de entidades do domínio do projeto, que são mapeadas para tabelas no banco de dados.
- **enums**: Contém enumerações utilizadas no projeto.
- **pk**: Contém classes de chaves primárias compostas de entidades.
- **repositories**: Contém interfaces que fornecem acesso aos dados do banco de dados (Repositories).
- **resources**: Contém classes de recursos da API que definem os endpoints para as operações CRUD.
- **exceptions**: Contém classes de exceção personalizadas para tratamento de erros específicos da API.
- **services**: Contém as classes de serviços que implementam a lógica de negócio da API.

## Endpoints da API

Os endpoints da API podem ser testados usando o [Postman](https://www.postman.com/). Abaixo estão os principais endpoints:

- **Auth**: Autenticação e Autorização.
  - `/oauth/token` (POST): Endpoint para autenticação com credenciais de login. Retorna um token de acesso e um token de atualização.
- **User**: Recursos relacionados aos usuários.
  - `/users/{id}` (GET): Obtém informações de um usuário pelo seu ID.
- **Deliver**: Recursos relacionados às entregas.
  - `/deliveries/{id}` (PUT): Atualiza o status e o feedback de uma entrega (deliver) específica.
- **Notification**: Recursos relacionados às notificações.
  - `/notifications` (GET): Obtém todas as notificações do usuário autenticado.

Os endpoints de autenticação são protegidos e requerem um token de acesso válido para serem acessados.

## Utilização no Postman

Para utilizar os endpoints da API, importe a coleção do Postman através do link [https://www.postman.com/collections/b156d5adf224f89f6ca3](https://www.postman.com/collections/b156d5adf224f89f6ca3). A coleção contém requisições configuradas para testar os principais endpoints da API.

Antes de testar as requisições, certifique-se de definir as variáveis de ambiente do Postman apropriadas para as informações de autenticação necessárias (por exemplo, `{{client-id}}`, `{{client-secret}}`, `{{username}}`, `{{password}}`, `{{host}}`, `{{token}}`, `{{refresh_token}}`). Estas informações podem variar dependendo da configuração da API e do ambiente de desenvolvimento.

