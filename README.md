# Desafio de Programação - Vaga Desenvolvedor

## Solução Implementada

Este repositório contém a solução para o desafio de programação proposto para a vaga de desenvolvedor, que consistia em criar uma aplicação para importar e visualizar dados de arquivos CNAB (formato bancário).

A solução implementada utiliza uma arquitetura em camadas, com backend em Java SpringBoot, frontend em Angular e banco de dados MySQL. Foram aplicados princípios S.O.L.I.D e Design Patterns no backend para promover robustez, escalabilidade e facilidade de manutenção.

## Arquitetura da Solução

A arquitetura da solução foi pensada em componentes isolados e desacoplados, visando a clareza e a organização do código:

*   **Backend (Java SpringBoot):** Responsável pela lógica de negócio, parseamento do arquivo CNAB, persistência dos dados no banco de dados MySQL e exposição da API REST para o frontend.
*   **Frontend (Angular):** Interface web para o usuário interagir com a aplicação, realizar o upload do arquivo CNAB e visualizar as transações financeiras por loja.
*   **Banco de Dados (MySQL):**  Utilizado para armazenar os dados das lojas, transações e informações de auditoria dos arquivos CNAB importados.

### Design e Padrões Aplicados no Backend

*   **Princípios S.O.L.I.D:** A arquitetura do backend foi desenvolvida seguindo os princípios S.O.L.I.D para garantir um código mais modular, flexível e fácil de manter.
*   **Design Patterns:**  Foram utilizados Design Patterns como **Factory** para a criação de serviços e regras de negócio, buscando desacoplar as camadas e facilitar a extensibilidade da aplicação.
*   **Camadas Desacopladas:** A aplicação foi estruturada em camadas bem definidas (Controller, Service, Repository, Model), promovendo a separação de responsabilidades e facilitando a evolução independente de cada camada.

## Modelagem de Dados

O modelo de dados foi projetado com as seguintes entidades principais e entidades de auditoria:

*   **Loja:**

    *   **lojaId (String):** Identificador único da loja, gerado como uma string Base64 a partir da concatenação do nome da loja e do nome do dono.
    *   **Representante (String):** Nome do representante da loja (Dono da Loja).
    *   **Nome da Loja (String):** Nome da loja.
    *   **Saldo (Double):** Saldo total da loja.

*   **Transação:**

    *   **transacaoId (Integer):** Identificador único da transação, gerado automaticamente pelo banco de dados.
    *   **TipoTransacao (Enum):**  Enumeração que define o tipo da transação (Débito, Boleto, etc.), sua natureza (Entrada/Saída) e o sinal (+/-) para cálculo do saldo.
    *   **DataOcorrencia (String):** Data da ocorrência da transação (formato String para manter o formato original do CNAB).
    *   **ValorMovimentacao (Double):** Valor da movimentação financeira.
    *   **CPFBeneficiario (Long):** CPF do beneficiário da transação.
    *   **Cartao (String):** Número do cartão utilizado na transação.
    *   **HoraOcorrencia (String):** Hora da ocorrência da transação (formato String para preservar zeros à esquerda).
    *   **loja\_Id (String):** Chave estrangeira referenciando a entidade `Loja`.

*   **ArquivoCNAB:**

    *   **arquivoId (Integer):** Identificador único do arquivo CNAB importado, gerado automaticamente.
    *   **nome (String):** Nome do arquivo CNAB (sem o caminho completo).
    *   **dataInclusao (LocalDateTime):** Data e hora de inclusão do arquivo.

*   **ConteudoArquivoCNAB:**

    *   **conteudoId (Integer):** Identificador único do conteúdo do arquivo CNAB, gerado automaticamente.
    *   **id\_arquivo (Integer):** Chave estrangeira referenciando a entidade `ArquivoCNAB`.
    *   **conteudoLinha (String):** Linha original do arquivo CNAB, sem tratamento.

## Endpoints da API REST

A API REST exposta pelo backend SpringBoot oferece os seguintes endpoints para interação com o frontend:

*   **`GET /api/consulta/lojas`**: Retorna uma lista de todas as lojas cadastradas, sem necessidade de parâmetros.
    *   **Resposta:** Lista de objetos `Loja` em formato JSON.

*   **`GET /api/consulta/transacao-por-loja`**: Retorna as transações financeiras de uma loja específica.
    *   **Parâmetros (Query):**
        ```json
        {
            "lojaId" : "$lojaId"
        }
        ```
    *   **Resposta:** Lista de objetos `Transacao` em formato JSON, filtradas pelo `lojaId` fornecido.

*   **`POST /api/parsefile/persist-file`**: Endpoint para realizar o upload do arquivo CNAB, parsear seu conteúdo, persistir os dados no banco de dados e retornar os dados interpretados.
    *   **Requisição:** `multipart/form-data` com o arquivo CNAB no campo `file`.
    *   **Resposta:** Lista de objetos representando os dados interpretados e persistidos (Lojas e Transações) em formato JSON.

    *   **Exemplo de Requisição (cURL):**
        ```bash
        curl -X POST -F "file=@/caminho/do/seu/arquivo.cnab" http://localhost:8080/api/parsefile/persist-file
        ```

## FrontEnd (Angular)

O frontend da aplicação foi desenvolvido em Angular e possui os seguintes componentes principais:

*   **Página Base (Layout):** Estrutura base da aplicação com menu lateral para navegação entre as funcionalidades.
*   **Componente de Upload de Arquivo:** Componente Angular para a tela de upload do arquivo CNAB, utilizando um formulário para seleção e envio do arquivo.
*   **Componente de Consulta de Transações:** Componente Angular para a tela de consulta e visualização das transações por loja, exibindo a lista de transações e o saldo total da loja.
*   **Services:**  Services Angular foram utilizados para desacoplar a lógica de apresentação da comunicação com a API backend, facilitando a manutenção e testabilidade do frontend.
*   **Proxy de Configuração:**  Arquivo `proxy.conf.json` configurado para direcionar as requisições do frontend para o backend em ambiente de desenvolvimento.

## Configuração e Execução

Para configurar e executar a aplicação, siga os passos abaixo para cada componente:

### Backend (Java SpringBoot)

1.  **Configuração do Banco de Dados:**
    *   Edite o arquivo `src/main/resources/application.properties` e configure as propriedades de acesso ao banco de dados MySQL (URL, usuário, senha). Certifique-se de que o banco de dados MySQL esteja instalado e em execução.

### Frontend (Angular)

1.  **Configuração do Backend URL:**
    *   Edite o arquivo `proxy.conf.json` na raiz do projeto Angular e configure a propriedade `target` para a URL onde o backend SpringBoot estará em execução (ex: `http://localhost:8080`).

### Execução da Aplicação

1.  **Backend (SpringBoot):**
    *   Navegue até o diretório raiz do projeto backend (SpringBoot) e execute o comando:
        ```bash
        ./mvnw spring-boot:run
        ```
        A aplicação backend estará disponível em `http://localhost:8080` (porta padrão do SpringBoot).

2.  **Frontend (Angular):**
    *   Navegue até o diretório raiz do projeto frontend (Angular) e execute o comando:
        ```bash
        npm install # Caso não tenha as dependências instaladas
        ng serve
        ```
        A aplicação frontend estará disponível em `http://localhost:4200` (porta padrão do Angular CLI).

3.  **Acesso à Aplicação:**
    *   Abra o navegador web e acesse o endereço do frontend Angular (`http://localhost:4200`).

## Docker Compose (Configuração Parcial)

Foram criados `Dockerfiles` para o backend (SpringBoot) e frontend (Angular). No entanto, a integração completa com `docker-compose.yml` não foi finalizada.

Para executar a aplicação utilizando Docker, siga as instruções nos `Dockerfiles` e configure o `docker-compose.yml` com os endereços dos containers do MySQL e SpringBoot, ajustando as configurações de rede e dependências conforme necessário.

**Observação:** A configuração completa do Docker Compose pode demandar ajustes adicionais para garantir a comunicação correta entre os containers e a configuração do banco de dados.

## Próximos Passos e Melhorias

*   **Implementação completa do Docker Compose:** Finalizar a configuração do `docker-compose.yml` para facilitar a execução e o deploy da aplicação em containers Docker.
*   **Testes Automatizados:** Implementar testes unitários no backend (SpringBoot) e testes de integração/e2e no frontend (Angular) para garantir a qualidade e cobertura do código.
*   **Documentação da API:** Gerar documentação da API REST utilizando ferramentas como Swagger ou OpenAPI para facilitar o consumo por outros sistemas.
*   **Autenticação e Autorização (OAuth):** Implementar autenticação e autorização na API, utilizando OAuth para garantir a segurança da aplicação e o controle de acesso aos dados.
*   **Melhorias na Interface do Usuário:** Aprimorar a interface do usuário do frontend, adicionando funcionalidades como paginação, filtros e gráficos para visualização dos dados.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir *issues* e *pull requests* para melhorias, correções de bugs e novas funcionalidades.

## Licença

"Este projeto não possui licença."

---

**Desenvolvido por:** \Felipe Garcia

**Repositório GitHub:** \https://github.com/sirGarcia/desafio-dev
