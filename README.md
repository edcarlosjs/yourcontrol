# Projeto pós graduação | Tech challenge - youdelivery fase 5

Projeto Teche Challenge realizado para pós-graduação [FIAP](https://www.fiap.com.br/) do curso de [Arquitetura e desenvolvimentoJAVA](https://postech.fiap.com.br/curso/arquitetura-desenvolvimento-java) propõe na quinta fase do curso o desenvolvimento de um sistema WEB, com interfaces e APIS, para cadastro de encomendas, fucionários e moradores, com a finalidade de gerenciar encomendas para prédios residenciais, por meio do qual porteiros recebam e organizem as entregas, utilizando tecnologias para que o sistema notifique moradores sobre a chegada das encomendas e para que eles confirmem seu recebimento. Além disso, esse sistema deve registrar automaticamente a retirada das encomendas na portaria. A API foi desenvolvida com as tecnologias Spring Boot, Spring Security, Java17, Maven e banco de dados local mysql. e banco de dados mysql em nuvem no Docker o objetivo de uma solução pratica com a utilização de endpoints para realização de operações  de criação, atualização e recuperação de registros. 

## Índice

1. [Tecnologias](#tecnologias)
2. [Ferramentas](#ferramentas)
3. [Documentação](/DOCUMENTACAO.md)
4. [Jornada](#jornada)
5. [Autor](#autor)
6. [Licença](#licença)

## Tecnologias

Tecnologias utilizadas durante o desenvolvimento do projeto.

### [Java 17](https://docs.oracle.com/en/java/javase/17/docs/api/)
Linguagem de programação escolhida para implementar a lógica do sistema, garantindo confiabilidade, segurança e escalabilidade.

### [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
Utilizado como framework para agilizar o desenvolvimento da API, oferecendo recursos como injeção de dependências, mapeamento de URLs, tratamento de requisições HTTP e muito mais.

### [h2](https://www.postgresql.org/docs/)
Banco de dados utilizado para armazenar e gerenciar as informações relacionadas a eletrodomésticos, endereços e pessoas. O PostgreSQL é conhecido por sua robustez e confiabilidade, adequado para aplicações de larga escala.

### [Maven](https://maven.apache.org/guides/index.html)
Gerenciador de dependências utilizado para facilitar a configuração e o gerenciamento das bibliotecas e dependências do projeto.


## Ferramentas

### [Eclipse IDE](https://eclipseide.org)
Ambiente de desenvolvimento integrado (IDE) utilizado para escrever, depurar e testar o código-fonte do projeto. O Eclipse possui recursos avançados de produtividade que facilitãoo desenvolvimento em Java e agiliza o processo de construção da API's.

### [mysql](https://www.mysql.com/)
Plataforma de colaboração e testes de API que permite enviar e receber solicitações HTTP, testar os endpoints da API, verificar as respostas e realizar a depuração de forma eficiente.

### [Git](https://git-scm.com/doc)
Sistema de controle de versão utilizado para rastrear alterações no código-fonte, facilitando o trabalho em equipe, o versionamento e a colaboração no projeto.

### [GitHub](https://github.com/)
Plataforma de hospedagem de repositórios de controle de versão Git, utilizada para armazenar e gerenciar o código-fonte do projeto. O GitHub permite o trabalho colaborativo, controle de versões, rastreamento de alterações e facilita a integração com ferramentas de desenvolvimento.

#### [Docker](https://www.docker.com/products/docker-desktop/)
Software de conteinização para desenvolvedores, possibilitando o empacotamento de uma aplicação ou ambiente dentro de um container, se tornando portátil para qualquer outro host que contenha o Docker instalado. Então, você consegue criar, implantar, copiar e migrar de um ambiente para outro com maior flexibilidade.

###Estruturas de Bancos de dados utilizados no Projeto

## Modelo de Banco de dados mysql Executado ao Subir a aplicação no Eclipse.

1. Tabelas Criadas no banco de dados mysql após subir a aplicação no Eclipse
   <img width="686" alt="Criando Tabelas no Postgree" src="">

2. Consutas realizadas no banco de dados mysql após inserção de dados utilizando o metodo Post através do Postman
  
   ## Consulta de registros de usuarios banco de dados mysql
   <img width="686" alt="Consulta Funcionarios mysql" src="">

   ## Consulta de funcionarios banco de dados mysql
   <img width="686" alt="Consulta Funcionarios mysql" src="">

   ## Consulta de moradores banco de dados mysql
   <img width="686" alt="Cosulta Moradores mysql" src="">

   ## Consulta de encomendas banco de dados mysql
   <img width="686" alt="Consulta Registro de Encomendas  hmysql " src="">

   ## Consulta cofirmação de encomendas banco de dados mysql
   <img width="686" alt="Consulta Confirmação de Recebimento Morador mysql" src="">

## Passos para a execução do projeto utilizando PostgreSQL

1. Instale o Docker Desktop e configure o PostgreSQL: 

#### *Script para subir meu servidor e banco mysql, kafka, zookeeper, adminer dock-springboot-app-1 no docker via terminal powershell* <br/><br/>
```   
version: "3.8"
services:
  # ====================================================================================================================
  # MYSQL SERVER
  # ====================================================================================================================
  mysql-db:
    image: mysql:8.0
    container_name: mysql-db
    environment:
      MYSQL_ROOT_PASSWORD: root_password
      MYSQL_DATABASE: test_db
      MYSQL_USER: user
      MYSQL_PASSWORD: user_password
    ports:
      - "3307:3306"
    volumes:
      - mysql_data:/var/lib/mysql
    networks:
      - mysql-network
  # ====================================================================================================================
  # ADMINER - INTERFACE DE GERENCIAMENTO DE BANCO DE DADOS
  # ====================================================================================================================
  adminer:
    image: adminer
    container_name: adminer
    environment:
      ADMINER_DEFAULT_SERVER: mysql-db
    ports:
      - "8080:8080"
    volumes:
      - mysql_data:/var/lib/mysql
    depends_on:
      - mysql-db
    networks:
      - mysql-network
  # ====================================================================================================================
  # ZOOKEEPER (Necessário para o Kafka)
  # ====================================================================================================================
  zookeeper:
    image: wurstmeister/zookeeper:3.4.6
    container_name: zookeeper
    ports:
      - "2181:2181"
    networks:
      - kafka-network
  # ====================================================================================================================
  # KAFKA
  # ====================================================================================================================
  kafka:
    image: wurstmeister/kafka:2.13-2.7.0
    container_name: kafka
    ports:
      - "9092:9092"
      - "9093:9093"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: INSIDE://kafka:9092,OUTSIDE://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INSIDE:PLAINTEXT,OUTSIDE:PLAINTEXT
      KAFKA_LISTENERS: INSIDE://0.0.0.0:9092,OUTSIDE://0.0.0.0:9093
      KAFKA_AUTO_CREATE_TOPICS_ENABLE: "true"
      KAFKA_INTER_BROKER_LISTENER_NAME: INSIDE
    depends_on:
      - zookeeper
    networks:
      - kafka-network
  # ====================================================================================================================
  # KAFKA drop
  # ====================================================================================================================
  kafdrop:
    image: obsidiandynamics/kafdrop
    ports:
      - "9000:9000"
    environment:
      KAFKA_BROKERCONNECT: kafka:9092
    depends_on:
      - kafka
  # ====================================================================================================================
  # SPRINGBOOT APP
  # ====================================================================================================================     
  springboot-app:
    build:
      context: C:/projetos/youdelivery  # Caminho para a pasta do projeto, onde o Dockerfile está
      dockerfile: Dockerfile  # O nome do Dockerfile
    ports:
      - "8080:8080"
    depends_on:
        - mysql-db
        - kafka
    networks:
      - spring-network
# ======================================================================================================================
# REDE
# ======================================================================================================================
networks:
  mysql-network:
    driver: bridge
  kafka-network:
    driver: bridge
  spring-network:
    driver: bridge
# ======================================================================================================================
# VOLUMES
# ======================================================================================================================
volumes:
  mysql_data:
  zookeeper_data:
  zookeeper_datalog:
  kafka_data:
```
#### *Passos para realizar após a execução do script pelo powershell* <br/><br/>

2. Execute e inicialize os serviços na sua máquina com o DockerDesktop 
   <img width="829" alt="Subindo serviços pgadmin e pgpostgres" src="">

3. Execute o mysql através do endereço![Logo do Markdown](img/markdown.png) http://localhost:8080
   <img width="829" alt="Acessando o mysql" src="">

4. Criando Tabelas no banco de dados Postgres
   <img width="829" alt="Criando Tabelas no mysql" src="">

4. Visualizando Base, schemas, tabelas e relacionamentos.
   <img width="829" alt="RelacionamentoTabelasPostgree" src="">

5. Consultas de tabelas no Mysql em nuvem pelo servidor Adminer. 
   
   ## Consulta de Clientes banco de dados Mysql
   <img width="829" alt="Consulta Cliente Postgres" src="">

   ## Consulta de Endereços banco de dados Mysql
   <img width="829" alt="Consulta Endereco Postgres " src="">

   ## Consulta de Veiculos banco de dados Mysql
   <img width="829" alt="Consulta Veiculo Postgres" src="">

   ## Consulta Parquimetro banco de dados Mysql
   <img width="829" alt="Consulta Parquimetro Postgres" src="">


## Jornada

### Qrimeira fase

O desenvolvimento do projeto foi muito desafiador uma vez que não trabalho como programador utilizando a linguagem de programação JAVA e também por ter encarado o desafio sozinho, obtive conhecimento com as live's no coda comigo e os videos da plataforma da Fiap e Alura. Para mim é tudo novo tenho o conhecimento bem superficial, espero ter atingido um pouco da espectiva do proposto no exercicio e pretendo aprimorar mais ainda com a continuidade da Quinta fase, com ela consegui obter um melhor desenpenho no desenvolvimento do que foi proposto para o negócio, com mais clareza e entendimento, consegui melhorar minha aplicação e utilizar nos processo de CRUD os conceitos de relacionamento OneToOne, ManyToOne, OneToMany, ManyToMany, tanto no contexto unidirecional quanto no bidirecional, aplicando as camadas de segurança e realizando o tratamento das exceções, para garantira a validação de dados e a sua segurança. Para mim foi muito interessante essa troca de experincia e informações nas lives, em meu projeto estou conseguindo aplicar muitas dicas e aprendizados, agora consigo enteder melhor meu código e como funciona e para que servem os padrões de camadas, consegui aplicar a utilização do banco de dados em nuvem não requerendo consumo da máquina local, além de possibilitar o desenvolvimento em ambientes diferentes como ambiente de desenvolvimento, ambiente de teste e ambiente de produção para quando for o caso de colocar a aplicação em nuvem, as novidades de mensageria e springsecurity foi munito desafiador para mim.

## Autor

- [Ed Carlos](email: rm349820@fiap.com.br;edcarlos.adm1@gmail.com)

Agradeço a minha esposa[Priscia Angelica da Silva] que continua contribuindo com o projeto me apoiando com as atividades pessoais em que não pude participar devido aos estudos.


## Licença

[Licença MIT](https://opensource.org/license/mit/): permite o uso, a modificação e a distribuição do software sem restrições significativas.

