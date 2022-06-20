# Crud com Java Spring e Angular

## Introdução

Um simples crud que serve como base para um desenvolvimento full-stack inicial de uma aplicação web que utiliza Java, Spring Boot e Angular, salvando tudo em um repositório utilizando git. 

Nada teórico vai ser mostrado aqui, apenas um passo a passo técnico para servir de consulta. Para estender a aplicação e o conhecimento, basta dar uma "googlada" nos termos e eventuais erros que tudo vai fazendo sentido e o aprendizado vai fluindo.

O ideal é já ter uma base de conhecimento em Lógica de Programação, POO, Java, Banco de Dados Relacional e TypeScript.

Obs: Foi utilizado o Windows 10 como Sistema Operacional, então algumas alterações terão que ser feitas para quando utilizar alguma distribuição Linux (ou Mac). 

<br>

## Essa aplicação faz o seguinte

Um usuário cadastra seu nome e vai adicionando conteúdos que ele consome, como filmes, livros, animes e por aí vai.

* [Pré-requisitos](#é-preciso-ter-instalado) 
* [Passo a Passo](#agora-vamos-ao-passo-a-passo)
  * [Git e GitHub](#git-e-github)
  * [Back-end](#back-end)
    * [Banco de Dados](#banco-de-dados)
    * [Spring](#spring-boot)
    * [Swagger](#swagger)
    * [Postman](#postman)
    
    
  * [Front-end](#front-end)
    * [Angular](#back-end)
    * [Bootstrap](#bootstrap)
  *  [Testes](#testes)
  *  [Deploy](#deploy)
  
* [Contato](#contato)

<br>

## É preciso ter instalado


- Git
  - também criar conta no GitHub 

- Java 8+

- Banco de dados MySQL 
  - login e senha configurados

- SGBD (DBeaver, Workbench)
  - não é necessário para rodar a aplicação

- Node.js LTS 

- Editor de texto (VScode, Atom, Notepad++, etc...)

- IDE (IntelliJ, Eclipse, etc...)

- Postman (logado também)

<br>

## Agora vamos ao passo a passo

<br>

## Git e GitHub

No site do GitHub com sua conta logada, ir em "Repositórios".

<img style="border-radius: 1%;" src="assets/repositories.png" width="500px;" alt=""/>

Depois em "Novo".

<img style="border-radius: 1%;" src="assets/novo.png" width="500px;" alt=""/>

Dê um nome ao projeto.

<img style="border-radius: 1%;" src="assets/nome-projeto-github.png" width="500px;" alt=""/>

Marque para adicionar o README (ou não, você quem sabe), e crie o repositório.

<img style="border-radius: 1%;" src="assets/criar-repositorio.png" width="500px;" alt=""/>

Com o repositório criado, vá em código e copie o link.

<img style="border-radius: 1%;" src="assets/copiar-nome-repo.png" width="500px;" alt=""/>

Abra a pasta que você queira deixar seu projeto armazenado na sua máquina, clique com o botão direito e depois em "Git Bash Here".

<img style="border-radius: 1%;" src="assets/git-bash-here.png" width="500px;" alt=""/>

Na janela aberta, escreva "git clone" dê um espaço e depois cole o link copiado com Shift + Insert.

<img style="border-radius: 1%;" src="assets/clonando.png" width="500px;" alt=""/>

Pronto, agora com o projeto na máquina, sempre que houver alterações, basta seguir os comandos:

-  git add arquivosCriados
  
ou

-  git add *

- git commit -m "mensagem do commit"  

- git push

Existem muitos outros comandos e funcionalidades do git, o ideal é ir testando e entendendo no decorrer do aprendizado.

<br>

# Back-end

<br>

## Banco de Dados

 (https://dev.mysql.com/downloads/installer/)

 O login e senha do banco, após instalado, serão usados nas configurações da aplicação no arquivo application.properties.

 As alterações feitas no pelo JPA poderão ser visualizadas no SGBD instalado.

 <img style="border-radius: 1%;" src="assets/dbeaver-bd.png" width="500px;" alt=""/>

## Spring Boot

Abra o site "Spring Initializr".

Configure no site:

- Project: Maven
- Language: Java
- Spring Boot: 2.7 (ou outra versão estável)
- Project Metadata:
  - Packaging: Jar
  - Java: 11 (ou sua versão instalada)
  - O resto não vai impedir o funcionamento, mas é interessante para organizar o projeto.
- Dependências:
  - Spring Boot DevTools
  - Spring Data JPA
  - Spring Web
  - MySQL Driver

E então gerar o projeto.

<img style="border-radius: 1%;" src="assets/startspringio.png" width="500px;" alt=""/>

Basta extrair o arquivo zip baixado no diretório desejado e abrir esse projeto na IDE.

<img style="border-radius: 1%;" src="assets/open-projeto.png" width="500px;" alt=""/>

E depois confirmar.

<img style="border-radius: 1%;" src="assets/open-projeto-2.png" width="500px;" alt=""/>

Agora é criar a seguinte estrutura de pacotes:


<img style="border-radius: 1%;" src="assets/criar-pacotes.png" width="500px;" alt=""/>

> controllers
> 
> services
> 
> repositories
> 
> models

Ficando assim:
<img style="border-radius: 1%;" src="assets/estrutura-pacotes.png" width="500px;" alt=""/>

Obs: O nome do arquivo fica em vermelho por não estar adicionado ao git. 

> Model

Crie uma nova classe dentro do pacote "models" com a abstração de um usuário.

O nome da classe pode ser "Usuario".

<img style="border-radius: 1%;" src="assets/cria-classe.png" width="500px;" alt=""/>

Anote a classe com "@Entity" e importe seu pacote (No caso do IntelliJ basta selecionar Ctrl + Espaço que aparecerão as opções). As anotações dizem ao Spring qual comportamento e funcionalidade a classe terá no sistema. Mas essa anotação pertence ao JPA para fazer o mapeamento da classe, assim como as demais anotações utilizadas nas classes de modelo.

```Java
import javax.persistence.Entity;

@Entity
public class Usuario {
}
```

E então implementar as abstrações da classe:

```Java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    String senha;
    String sobrenome;

    // Construtor, Getters, Setters, Equals e HashCode

}
```

As IDEs ajudam na criação dos:

- Construtores
- Getters e Setters
- Equals e HashCode

Basta clicar com o botão direito (ou utilizar o atalho).

<img style="border-radius: 1%;" src="assets/generate-ides.png" width="500px;" alt=""/>

```Java
    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String sobrenome) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sobrenome = sobrenome;
    }

    // Getters, Setters, Equals e HashCode

```

Da mesma maneira criar uma classe para representar a mídia que o usuário consome. A anotação "@ManyToOne" é para dizer ao JPA que um "Usuario" pode ter vários objetos "Midia" associados a ele, criando uma relação no banco de dados seguindo o sentido da anotação. 

```Java
@Entity
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titulo;
    String tipo;
    String nota;
    String descrição;
    @ManyToOne
    Usuario usuario;

    // Construtor, Getters, Setters, Equals e HashCode

}
```

> Repository

Da mesma maneira que as classes foram criadas, crie uma interface (basta alterar o nome Classe para Interface) com o mesmo nome do model seguido de "Repository" dentro do pacote repositories.

Ficando assim:

<img style="border-radius: 1%;" src="assets/model-e-repo-estrutura.png" width="500px;" alt=""/>

Ao criar a interface estará assim:

```Java
public interface UsuarioRepository {
}
```

Depois estenda a interface "JpaRepository" e adicione a anotação "@Repository".

```Java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
```

> Service

Da mesma maneira que as classes foram criadas, crie uma classe no pacote "service" com o mesmo nome do model seguido de "Service".

<img style="border-radius: 1%;" src="assets/service-estrutura.png" width="500px;" alt=""/>

Dentro de cada classe, monte a seguinte estrutura:

```Java

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElse(null);
    }
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    public Usuario update(Long id, Usuario obj) {
        Usuario newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setSobrenome(obj.getSobrenome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        return repository.save(newObj);
    }
    public Usuario create(Usuario obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
    
}
```

A anotação @Service diz ao Spring que é nesta classe que as regras de negócio da aplicação estarão, e a anotação @Autowired faz a injeção de dependência, deixando a cargo do Spring.

Com isso, a lógica do CRUD está implementada, já é possível criar, alterar, deletar, encontrar usuário pelo Id e retornar todos os usuários. Agora basta replicar essa mesma lógica para a classe "MidiaService".

> Controllers

Só falta implementar a porta de acesso da aplicação. Crie uma classe no pacote "controllers" com o mesmo nome do model seguido de "Controller".

A implementação de "UsuarioController" fica assim:

```Java

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioControllers {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> GetById(@PathVariable Long id) {
        Usuario obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> GetAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
        Usuario newObj = service.create(usuario);
        return ResponseEntity.status(HttpStatus.GONE).body(service.create(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> Put(@PathVariable Long id, @RequestBody Usuario obj) {
        Usuario newUsuario = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

```

A anotação @CrossOrigin("*") define quem pode interagir com os endpoints.

@RestController define o tipo da classe para o entendimento por parte do Spring.

@RequestMapping("/usuario") define o endpoint daquele controller.

@GetMapping, @PostMapping, @PutMapping e @DeleteMapping são os verbos HTTP para que haja a comunicação REST.

Por fim, é preciso "settar" algumas configurações no arquivo "applications.properties", referentes ao banco de dados que foi instalado na máquina, onde será necessário dizer à aplicação a senha e login do banco de dados que foi definido na sua instalação, pra isso, basta adicionar o seguinte código:

```properties
server.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
# altere removendo os colchetes
spring.datasource.url=jdbc:mysql://localhost:/[NOME_DO_BANCO]?createDatabaseIfNotExist=true
spring.datasource.username=[SEU_LOGIN]
spring.datasource.password=[SUA_SENHA]
spring.jpa.show-sql=true
spring.mvc.pathmatch.matching-strategy=ant-path-matcher
```

E com isso já podemos testar o back-end no Postman, basta clicar com o botão direito na classe principal da aplicação "CrudApplication" e clicar na opção "run" (Ctrl + Shift + F10)

<img style="border-radius: 1%;" src="assets/estrutura-back-end.png" width="500px;" alt=""/>

## Swagger

Para ter uma boa documentação e entendermos bem nossa API, um bom caminho é utilizar o Swagger.

Primeiro copie e cole as dependências do Swagger no arquivo "pom.xml" (ele está na mesma hierarquia do pacote "src"), dentro da tag "<dependencies></dependencies>" junto com as outras dependências da aplicação.

```xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-boot-starter</artifactId>
	<version>3.0.0</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>3.0.0</version>
</dependency>
```

Obs: Alterações forem feitas no gerenciador de pacotes é preciso recarregar o Maven.

<img style="border-radius: 1%;" src="assets/maven-reload.png" width="500px;" alt=""/>

 Então é só criar um pacote chamado "configurations" para organizar classes com objetivo de configurar alguma funcionalidade da API. Depois basta criar uma classe chamada "SwaggerConfigurations" e implementar o código:

```Java
@Configuration
public class SwaggerConfigurations {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //coloque o caminho do pacote controller no parâmetro do basePackage
                .apis(RequestHandlerSelectors.basePackage("caminho.do.pacote.controller"))
                .paths(PathSelectors.ant("/**"))
                .build();

    }
}
```

Depois do projeto rodando é só colar a url "http://localhost:8081/swagger-ui/index.html" no seu navegador para abrir o Swagger UI.

## Postman

Agora podemos facilmente testar os endpoints de POST, GET, PUT e DELETE através do Postman. 



# Front-end

## Angular

## Bootstrap



## Testes

## Deploy

## Contato


<address>
  <a href="mailto:izzydays@hotmail.com">
    <img src="assets/logomail.png" style="border-radius: 1%;" alt="Logo" width="45">
  </a> 
  <- Send me a mail
<br><br>

  <a href="https://www.linkedin.com/in/israellimadias/">
    <img src="assets/logolinkedin.png" style="border-radius: 10%;" alt="Logo" width="42">
  </a>
  <- Let's connect   
<br>
</address>
<br>

<p align="center"> : ) </p>