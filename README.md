# Mindsait  
Este projeto foi criado para a participação no processo trainee da Empresa minsait. O desafio consistia em desenvolver uma aplicação API Rest para gerenciar clientes e empréstimos. Esta API deveria conter um CRUD e o relacionamento entre duas tabelas (Clientes e Empréstimos), onde a entidade pessoa poderia receber mais de um Empréstimo.  

# Estrutura do projeto

O projeto está dividido em uma estrutura MVC.
O projeto foi construído com Spring Boot 4 na linguagem Java. 
Existe também uma camada de banco de dados desenvolvida com H2 (banco em mamória) para persistência de dados  das entidades  durante a execução da aplicação.


# Endpoints da API

Entidade Cliente

@GetMapping("localhost:8080/api/v1/fintech/clientes") usado para listar todas os clientes cadastrados.

@GetMapping(localhost:8080/api/v1/fintech/clientes/{cpf}) usado para consultar um cliente pela sua chave prmária(cpf). 

@PostMapping(localhost:8080/api/v1/fintech/clientes) usado para criar uma entidade cliente.

@PutMapping(localhost:8080/api/v1/fintech/clientes) usado para editar um cliente já cadastrado.

@DeleteMapping(localhost:8080/api/v1/fintech/clientes)  usado para deletar um cliente pelo sua chave prmária(cpf).

Entidade Empréstimo

@GetMapping("localhost:8080/api/v1/fintech/clientes/emprestimos") usado para listar todos os empréstimos cadastrados.

@GetMapping(localhost:8080/api/v1/fintech/clientes/{cpf}/emprestimos/{{id}}) usado para consultar um empréstimo de um cliente pela sua chave prmária(cpf) e id do empréstimo. 

@PostMapping(localhost:8080/api/v1/fintech/clientes/{cpf}/emprestimos) usado para criar um novo empréstimo, precisa passar por parametro o cpf (chave estrangeira)da entidade cliente.

@DeleteMapping(localhost:8080/api/v1/fintech/clientes/{cpf}/emprestimos/{{id}})  usado para excluir um empréstimo pela chave estrangeira(cpf) do cliente e chave primária(id) do empréstimo .

## Dependências utilizadas

Para a aplicação em Spring foram usadas, principalmente, as dependências do maven e do próprio framework spring.

Usamos o lombok para diminuir a quantidade de código

Usamos também o swagger para documentação, você pode acessar, após subir o servidor, através do swagger-ui = http://localhost:8080/swagger-ui/index.html

Foi usado também o Junit para alguns testes da Entidade Empréstimo.

Para a camada de banco de dados foi utilizada a seguinte dependência: H2 banco em memória.

## Execução da aplicação

Neccessáio baixar o código do projeto,fork, abri-lo em alguma IDE, recomendo o eclipse, subir o servidor e acessá-lo no localhost:8080/h2.

OBS: no arquivo aplication.properties a linha #spring.sql.init.mode = always, popula alguns clientes e empréstimos automáticamente, caso queira e só acessar o arquivo
e retirar o # do início , lembrando que se você utilizá-lo e por algum motivo precisar levantar o servidor novamente irá ocorrer um erro, pois o banco não aceita dois cpfs iguais,
será necessário voltar com o # no inicio da linha após a primeira excecução do servidor.

Também disponibilizo a collection do postman, com a massa de dados já salva, para facilitar os testes, só baixar o arquivo json, mindsit.postman_collection.json, importar no próprio e efetuar as correções na url.

## Testes
Testes foram realizados através da ferramenta Postman, onde foi possivel tester todos os endpoints.

## Conhecimentos adquiridos e dificuldades encontradas

* Rotina de CRUD.
* Criar uma interface assíncrona para comunicação  com o H2, usando o relacionamento de muitos para um entre as duas entidades, usando chave estrangeira.

##Execução  
        Execução na porta 8080;
        Acesso através do swagger-ui = (http://localhost:8080/swagger-ui/index.html)

###### Considerações finais

Agradeço a oportunidade da participação no processo seletivo!!
