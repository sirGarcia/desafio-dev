# Desafio Programação.
Nesse desafio foi apresentado um arquivo CNAB com formato devidamente descrito e foi pedido para que fosse interpretado e persistido, além da criação de uma forma de inserir um arquivo e visualizar os dados inseridos por loja. 

## Solução.
Minha proposta foi utilizar um banco de dados MySQL com backend em Java com SpringBoot e um frontend em Angular.
A parte do backend eu utilizei alguns conceitos S.O.L.I.D e alguns Design patterns pensando em tornar a solução mais robusta e de mais fácil crescimento. 
Deixando a solução com camadas desacopladas, fabricas de serviço e fabricas de regras de negocio. 

## Modelagem.
Para a modelagem dessa solução eu pensei em duas entidades principais e duas entidades de auditoria. 
1. Loja 
    - lojaId (String). Optei por usar um id gerado com uma string Base64 da concatenação do nome da loja e do nome do dono.
    - Representante (String). Dono da loja segundo a documentação 
    - Nome da Loja (String). 
    - Saldo (Double).
2. Transação
    - TransaçãoId (Integer). Gerado automaticamente. 
    - Tipo Transação (Enum). Enum criado com a configuração do tipo de transação e a função de soma ou subtração de saldo. 
    - Data ocorrencia (String).
    - Valor da movimentação (Double).
    - CPF do Beneficiario (Long)
    - Cartao (String)
    - Hora da Ocorrencia (String). Optei por usar string pois a hora poderia ser 000000 o que salvaria apenas como 0 deixando o valor numerico. 
    - FK para loja com loja_Id. 
3. ArquivoCNAB
    - arquivoId (Integer). Gerado automaticamente.
    - nome (String). Nome do arquivo inserido sem caminho, somente nome final. 
    - dataInclusao (LocalDateTime). Data da inclusão. 
4. ConteudoArquivoCNAB
    - conteudoId (Integer). Gerado automaticamente.
    - FK para arquivoCNAB na coluna id_arquivo. 
    - conteudoLinha (String). Linha sem nenhum tratamento.

## EndPoints
Para fazer interface com o frontend optei por expor apenas os endpoints que seriam usados e são eles: 
    - /api/consulta/lojas (get)
        - Retorna todas as lojas e não requer nenhum parametro 
    - /api/consulta/transacao-por-loja (get)
        - Retorna as transações de uma loja especifica e requer um parametro
        - Parametro {"lojaId" : $lojaId}
    - /api/parsefile/persist-file (post)
        - Insere as entidades arquivoCNAB, conteudoArquivoCNAB
        - Interpreta o arquivoCNAB conforme Enum de configuração criado 
        - Persiste os dados interpretado nas tabelas de Loja e Transação
        - Retorna todos os dados interpretados e persistidos
        - Requisição multipart / form-data 

## FrontEnd
Foi criado uma Pagina base com menu lateral com as opções de inserir arquivo e consultar transações. 
Foi criado um angular componente para cada uma das funcionalidades e eles são gerados e destruidos dinamicamente. 
No desenvolvimento do frontend também foram aplicados algumas tencicas como services. 
frontend possui um arquivo de proxy para configuração do backend. 

## Configurar e Rodar 
Para configurar e rodar a aplicação temos 3 componentes isolado que serão integrados nos arquivos de configuração 

1. Backend (Java SpringBoot)
    - Necessita configurar o banco no arquivo [application.properties](desafio-backend/src/main/resources/application.properties)
2. Frontend (AngularJs)
    - Necessita configurar o arquivo [proxy.conf.json](desafio-app\desafio-dev\proxy.conf.json) com a url onde esta aplicado o backend

Após essas simples configurações sua aplicação esta pronta e é só chamar o endereço que o serviço do angular esta escutando. 

## Docker compose 

Eu fiz alguns estudos e criei os arquivos Dockerfile do backend e do frontend, como ja havia criado em outros projetos. 
Porém não consegui integrar tudo no [docker-compose.yml](docker-compose.yml)
Caso a aplicação seja aplicada em docker só configurar os arquivos acima com os endereços dos containers do MySQL e do SpringBoot (backend).