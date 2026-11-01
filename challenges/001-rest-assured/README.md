# LAB-001 — REST Assured e integração HTTP

## Objetivo

Praticar testes de API REST com Spring Boot e REST Assured MockMvc. A base da aplicação já está implementada; **os testes são sua responsabilidade**.

## Tecnologia

- Java 21 e Spring Boot 3.5.7
- Maven e JUnit Jupiter
- Bean Validation
- Armazenamento **em memória**, sem banco de dados para manter o foco em HTTP e testes

## Executar

Na pasta `challenges/001-rest-assured`:

```bash
mvn spring-boot:run
mvn test
```

O projeto pressupõe Java 21 e Maven instalados. O endpoint raiz da API é `http://localhost:8080/products`.

## API fornecida

### Criar produto

`POST /products`

```json
{"name":"Keyboard","price":129.90}
```

Esperado: `201 Created`, header `Location: /products/{id}` e corpo com `id`, `name` e `price`.

### Consultar produto

`GET /products/{id}`: `200 OK` e produto existente; `404 Not Found` quando não existir, com `code: PRODUCT_NOT_FOUND`.

### Listar produtos

`GET /products`: `200 OK` e array JSON, ordenado por identificador.

### Validação

`POST /products` com `name` em branco ou `price` nulo/menor que 0.01: `400 Bad Request`. O corpo de erro usa o comportamento padrão do Spring Boot; não exija um formato customizado nesta fase.

## Sua missão — somente LAB-001

1. Escolher e adicionar ao `pom.xml` a dependência apropriada para **REST Assured MockMvc**, com escopo de teste.
2. Configurar o contexto de teste Spring MVC, utilizando `MockMvc` com REST Assured MockMvc (não precisa subir porta real).
3. Implementar no mínimo estes cenários, com asserções de **status, header e/ou corpo conforme aplicável**:
   - POST válido retorna 201 e `Location`; confere propriedades do JSON.
   - GET de produto criado retorna 200 com identificador e nome corretos.
   - GET de identificador inexistente retorna 404 e `code = PRODUCT_NOT_FOUND`.
   - POST com nome em branco retorna 400.
   - POST com preço inválido retorna 400.
   - GET /products retorna um array JSON.
4. Não modificar código de produção exceto para corrigir defeito real que o teste comprove.
5. Registrar no Pull Request o que foi consultado no AlgaShop e uma decisão de teste que você tomou.

## Observações

- O estado em memória é compartilhado pelo contexto Spring: testes não devem pressupor uma base sempre vazia nem IDs fixos. Gere o produto de que precisar dentro do cenário.
- Não é necessário usar Testcontainers, PostgreSQL, WireMock, RabbitMQ nem Spring Cloud Contract nesta etapa.
- A classe `ProductControllerIT` é apenas um esqueleto; os três métodos iniciais contêm TODOs e não constituem testes efetivos.
- `mvn test` com Surefire normalmente não executa classes terminadas em `IT`. **Você também deve escolher e configurar um modo de executar seus testes**, por exemplo renomear para `ProductControllerTest` ou configurar o Failsafe. Explique sua escolha.

## Critério de aceite

- Testes realmente executados pelo Maven, com verificações relevantes, todos passando.
- Nenhuma dependência desnecessária de serviços externos.
- Código legível e cenários independentes de ordem.
- Pull Request com breve explicação das decisões e referências consultadas.

## Próximos módulos (não implementar ainda)

- LAB-002 — WireMock e integração com catálogo externo
- LAB-003 — Testes de contratos com Spring Cloud Contract

O revisor dará feedback sobre comportamento, isolamento, clareza e justificativa técnica, sem fornecer solução pronta antecipadamente.
