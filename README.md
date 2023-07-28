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

### Pacote components

Contém componentes relacionados a melhorias no token JWT.

- `JwtTokenEnhancer.java`: Componente responsável por aprimorar o token JWT com informações adicionais durante o processo de autenticação e autorização.

### Pacote config

Contém classes de configuração, como a configuração do servidor de autorização, servidor de recursos e segurança web.

- `AppConfig.java`: Configurações gerais da aplicação Spring Boot.
- `AuthorizationServerConfig.java`: Configuração do servidor de autorização OAuth 2.0 para gerenciar os tokens de acesso.
- `ResourceServerConfig.java`: Configuração do servidor de recursos OAuth 2.0 para proteger os endpoints da aplicação.
- `WebSecurityConfig.java`: Configuração da segurança da aplicação, definindo as regras de autenticação.

### Pacote dto

Contém classes Data Transfer Object (DTO) para transferir dados entre a API e a camada de serviço.

- `DeliverRevisionDTO.java`: DTO (Data Transfer Object) para a revisão de uma entrega.
- `NotificationDTO.java`: DTO para representar uma notificação.
- `UserDTO.java`: DTO para representar um usuário.

### Pacote entities

Contém as classes de entidades que são mapeadas para tabelas no banco de dados:

- `Content.java`: Entidade que representa o conteúdo de um recurso.
- `Course.java`: Entidade que representa um curso.
- `Deliver.java`: Entidade que representa uma entrega de tarefa.
- `Enrollment.java`: Entidade que representa a matrícula de um usuário em um curso.
- `Lesson.java`: Entidade que representa uma aula de um curso.
- `Notification.java`: Entidade que representa uma notificação.
- `Offer.java`: Entidade que representa a oferta de um curso.
- `Reply.java`: Entidade que representa a resposta a uma tarefa.
- `Resource.java`: Entidade que representa um recurso.
- `Role.java`: Entidade que representa uma função (perfil) de usuário.
- `Section.java`: Entidade que representa uma seção de um curso.
- `Task.java`: Entidade que representa uma tarefa.
- `Topic.java`: Entidade que representa um tópico.
- `User.java`: Entidade que representa um usuário.

### Pacote enums

- `DeliverStatus.java`: Enumeração para os possíveis status de uma entrega.
- `ResourceType.java`: Enumeração para os tipos de recursos.

### Pacote pk

Contém classes de chaves primárias compostas de entidades.

- `EnrollmentPK.java`: Classe que representa a chave primária composta da entidade Enrollment.

### Pacote repositories

 Contém interfaces que fornecem acesso aos dados do banco de dados (Repositories).

- `CourseRepository.java`: Interface do repositório para a entidade Course.
- `DeliverRepository.java`: Interface do repositório para a entidade Deliver.
- `EnrollmentRepository.java`: Interface do repositório para a entidade Enrollment.
- `LessonRepository.java`: Interface do repositório para a entidade Lesson.
- `NotificationRepository.java`: Interface do repositório para a entidade Notification.
- `OfferRepository.java`: Interface do repositório para a entidade Offer.
- `ReplyRepository.java`: Interface do repositório para a entidade Reply.
- `ResourceRepository.java`: Interface do repositório para a entidade Resource.
- `RoleRepository.java`: Interface do repositório para a entidade Role.
- `SectionRepository.java`: Interface do repositório para a entidade Section.
- `TopicRepository.java`: Interface do repositório para a entidade Topic.
- `UserRepository.java`: Interface do repositório para a entidade User.

### Pacote resources

Contém classes de recursos da API que definem os endpoints para as operações CRUD.

- `DeliverResource.java`: Classe de recurso que representa o endpoint para entregas.
- `NotificationResource.java`: Classe de recurso que representa o endpoint para notificações.
- `UserResource.java`: Classe de recurso que representa o endpoint para usuários.

### Pacote exceptions

 Contém classes de exceção personalizadas para tratamento de erros específicos da API.

- `FieldMessage.java`: Classe para representar mensagens de erro de campos.
- `OAuthCustomError.java`: Classe para representar erros personalizados de autenticação e autorização.
- `ResourceExceptionHandler.java`: Classe para lidar com exceções globais na aplicação.
- `StandardError.java`: Classe para representar erros padrão.
- `ValidationError.java`: Classe para representar erros de validação.

### Pacote services

Contém as classes de serviços que implementam a lógica de negócio da API.

- `AuthService.java`: Interface do serviço de autenticação.
- `DeliverService.java`: Interface do serviço de entrega.
- `NotificationService.java`: Interface do serviço de notificação.
- `UserService.java`: Interface do serviço de usuário.

### Pacote exceptions

- `DatabaseException.java`: Exceção personalizada para erros relacionados ao banco de dados.
- `ForbiddenException.java`: Exceção personalizada para erros de acesso não autorizado.
- `ResourceNotFoundException.java`: Exceção personalizada para erros de recurso não encontrado.
- `UnauthorizedException.java`: Exceção personalizada para erros de autenticação e autorização.


### Endpoints da API

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

### Utilização no Postman

Para utilizar os endpoints da API, importe a coleção do Postman através do link [https://www.postman.com/collections/b156d5adf224f89f6ca3](https://www.postman.com/collections/b156d5adf224f89f6ca3). A coleção contém requisições configuradas para testar os principais endpoints da API.

Antes de testar as requisições, certifique-se de definir as variáveis de ambiente do Postman apropriadas para as informações de autenticação necessárias (por exemplo, `{{client-id}}`, `{{client-secret}}`, `{{username}}`, `{{password}}`, `{{host}}`, `{{token}}`, `{{refresh_token}}`). Estas informações podem variar dependendo da configuração da API e do ambiente de desenvolvimento.

