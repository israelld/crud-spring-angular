# Crud com Java Spring e Angular

> Introdução

Um simples crud que serve como base para um desenvolvimento full-stack inicial de uma aplicação web que utiliza Java, Spring Boot e Angular, salvando tudo em um repositório utilizando git. 

Nada teórico vai ser mostrado aqui, apenas um passo a passo técnico para servir de consulta. Para extender a aplicação e o conhecimento, basta dar uma "googlada" nos termos e eventuais erros que tudo vai fazendo sentido e o aprendizado vai fluindo.

> É preciso ter instalado


- Git
  - também criar conta no github 

- Java 8+

- Banco de dados MySQL

- SGBD (DBeaver, Workbench)

- Node.js lts 

- Angular CLI

- Editor de texto (VScode, Atom, notepad++, etc...)

- IDE (IntelliJ, Eclipse, etc...)

> Essa aplicação faz o seguinte

Um usuário cadastra seu nome e vai adicionando conteúdos que ele consome, como filmes, livros, animes e por aí vai.

## Agora vamos ao passo a passo

> Git e Github

No site do github com sua conta logada, ir em "Repositórios".

<img style="border-radius: 1%;" src="assets/repositories.png" width="1000px;" alt=""/>

Depois em "Novo".

<img style="border-radius: 1%;" src="assets/novo.png" width="1000px;" alt=""/>

Dê um nome ao projeto.

<img style="border-radius: 1%;" src="assets/nome-projeto-github.png" width="1000px;" alt=""/>

Marque para adicionar o README (ou não, você quem sabe), e crie o repositório.

<img style="border-radius: 1%;" src="assets/criar-repositorio.png" width="1000px;" alt=""/>

Com o repositório criar, vá em código e copie o link.

<img style="border-radius: 1%;" src="assets/copiar-nome-repo.png" width="1000px;" alt=""/>

Abra a pasta que você queira deixar seu projeto armazenado na sua máquina, clique com o botão direito e depois em "Git Bash Here".

<img style="border-radius: 1%;" src="assets/git-bash-here.png" width="1000px;" alt=""/>

Na janela aberta, escreva "git clone" dê um espaço e depois cole o link copiado com Shift + Insert

<img style="border-radius: 1%;" src="assets/clonando.png" width="1000px;" alt=""/>

Pronto, agora com o projeto na máquina, sempre que houver alterações, basta seguir os comando de:

-  git add arquivosCriados
  
ou

-  git add *

- git commit -m "mensagem do commit"  

- git push

Existem muitos outros comando e funcionalidades do git, o ideal é ir testando e entendendo no decorrer do aprendizado.

> Back-end

Abrir o site "Spring Initializr".

Configurar no site:

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

<img style="border-radius: 1%;" src="assets/startspringio.png" width="1000px;" alt=""/>

Gerar o projeto.

