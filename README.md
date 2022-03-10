<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/glaubermatos/jobscalc-api?color=%2304D361&style=flat">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/glaubermatos/jobscalc-api?style=flat">
  
  <a href="https://github.com/glaubermatos/jobscalc-api/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/glaubermatos/jobscalc-api?style=flat">
  </a>
    
   <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen?style=flat">
  
</p>

<h1 align="center">
    <img src="./.github/logo.svg" />
</h1>


<h4 align="center"> 
	🚧  Aplicação finalizada! 🚧
</h4>

## 🏁 Tópicos

<p>
 👉<a href="#-sobre-o-projeto" style="text-decoration: none; "> Sobre</a> <br/>
👉<a href="#-funcionalidades" style="text-decoration: none; "> Funcionalidades</a> <br/>
👉<a href="#-melhorias" style="text-decoration: none; "> Melhorias</a> <br/>
👉<a href="#-demonstracao" style="text-decoration: none"> Demonstração</a> <br/>
👉<a href="#-como-executar-o-projeto" style="text-decoration: none"> Como executar</a> <br/>
👉<a href="#-tecnologias" style="text-decoration: none"> Tecnologias</a> <br/>
👉<a href="#-autor" style="text-decoration: none"> Autor</a> <br/>
👉<a href="#-user-content--licença" style="text-decoration: none"> Licença</a>

</p>

## 💻 Sobre o projeto

API Rest com Java Spring-boot para cadastrar e calcular o valor dos seus projetos freelancers de forma simples e fácil. A partir de um perfil criado com github informe seu planejamento financeiro e pronto, o sistema irá calcular o valor da sua hora de trabalho.

Cadastre seus freelas informando a quantidade de horas estimada para sua conclusão e o sistema calcula o valor do Job com base no valor da sua hora de trabalho.

Este projeto foi desenvolvido para complementar o projeto frontend e consolidar alguns conhecimentos técnicos nas tecnologias fullstack Java + React.

O projeto frontend jobscalc está disponível **[AQUI](https://github.com/glaubermatos/jobscalc)**

---

<a name="-funcionalidades"></a>

## ⚙️ Funcionalidades

- [x] Perfil:
    - [x] Cadastro de novos perfis:
    - [x] Buscar perfil por email;
    - [x] Atualizar dados do perfil;
- [x] Job:
    - [x] Cadastro de novos jobs;
    - [x] Editar dados do job;
    - [x] Excluir job;
- [x] Segurança com Spring Security;
- [x] Método de autenticação simples com HTTP Basic;

### Rotas

- PERFIL
    - [x] - POST /api/profiles - Cria um novo perfil de usuário
    - [x] - PUT /api/profiles/[profileId] - Atualiza dados do perfil do usuário
- JOBS
    - [x] - GET /api/profiles/[profileId]/jobs - Lista os jobs do perfil do usuário
    - [x] - POST /api/profiles/[profileId]/jobs - Cria um novo job
    - [x] - PUT /api/profiles/[profileId]/jobs/[jobId] - Atualiza dados do job
    - [x] - DELETE /api/profiles/[profileId]/jobs/[jobId] - Deleta o job
    - [x] - GET /api/profiles/[profileId]/jobs/[jobId] - Lista os dados do job
    - OPERAÇÕES NÃO CRUD
        - [x] PUT /api/profiles/[profileId]/jobs/[jobId]/inprogress - Altera o status do job para Em andamento
        - [x] PUT /api/profiles/[profileId]/jobs/[jobId]/closed - Altera o status do job para Encerrado
    

---
<a name="-melhorias"></a>

## ⚙️ Melhorias
- [x] Pode ser adicionado mais funcionalidades como páginação dos jobs 

---

<a name="-demonstracao"></a>

## 🕹️ Demonstração
Neste link pode ser visualizado o resultado final do projeto: Backend + Frontend

<a align="center" href="https://www.linkedin.com/posts/glaubermatos_desenvolvimentoweb-springboot-nextjs-activity-6905992105182015488-CfRu">
    <img alt="jobscalc" src="https://img.shields.io/static/v1?label=post&message=jobscalc&color=F1972C&style=flat&logo=linkedin">
</a>

---

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [AdoptOpenJDK-11](https://adoptopenjdk.net/).
Além disto é bom ter uma IDE para auxiliar no desenvolvimento como [STS4](https://spring.io/tools).
Caso queira rodar o projeto sem uma IDE para auxiliar tenha instalado o [Maven](https://maven.apache.org/).


#### 🧭 Clonando o projeto (Backend)

```bash

# Clone este repositório
$ git clone https://github.com/glaubermatos/jobscalc-api.git

# entrar na pasta do projeto back end
cd jobscalc-api

# executar o projeto com maven
./mvnw spring-boot:run

```


#### 🧭 Abra o projeto com o STS4

Neste momento o STS4 vai fazer o download das dependencias do projeto. Após a conclusão, executar a classe JobscalcapiApplication.java.

#### 🧭 Testando as rotas da API

A api está configurada com HTTP Basic Auth, logo, todas as requisições devem possuir em seus headers as credenciais de acesso

AS configurações das credenciais do HTTP Basic Auth podem ser alterdas no arquivo [application-dev.properties](https://github.com/glaubermatos/jobscalc-api/blob/main/src/main/resources/application-dev.properties)

As configurações de credenciais do spring security:

```
spring.security.user.name=jobscalc-web
spring.security.user.password=123456
```

---

## 🛠 Tecnologias

O Jobscalc-api é uma api rest desenvolvida em Java utilizando as seguintes tecnologias:

#### **Backend**

- **[Spring-boot 2.6.2](https://spring.io/projects/spring-boot)**
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**
- **[Spring Security](https://spring.io/projects/spring-security)**
- **[Java Persistence API (JPA)](https://www.ibm.com/docs/pt-br/was/8.5.5?topic=SSEQTP_8.5.5/com.ibm.websphere.nd.multiplatform.doc/ae/cejb_persistence.html)**
- **[Maven](https://maven.apache.org/)**
- **[Bean Validation](https://beanvalidation.org/)**
- **[H2 DataBase](https://www.h2database.com/)**

> Veja o arquivo [pom.xml](https://github.com/glaubermatos/jobscalc-api/blob/main/pom.xml)

#### **Utilitários**

- Editor: **[Spring Tools Suite 4](https://spring.io/tools)**
- Testes da API: **[Insomnia](https://insomnia.rest/)**

---

<a name="-autor"></a>

## 🦸‍♂️ **Autor**

<p>
 <img src="https://avatars.githubusercontent.com/u/10993285?v=4" width="150px;" alt="glaubermatos"/>
 <br />
 <sub><strong>🌟 Glauber de Oliveira Matos 🌟</strong></sub>
</p>

[![Linkedin Badge](https://img.shields.io/badge/-linkedin-blue?style=flat&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/glaubermatos/)](https://www.linkedin.com/in/glaubermatos/)

---
<a name="-user-content--licença"></a>

## 📝 Licença

Este projeto esta sobe a licença [MIT](./LICENSE).

Feito com :satisfied: por Glauber de Oliveira Matos 👋🏽 [Entre em contato!](https://www.linkedin.com/in/glaubermatos/)

---
