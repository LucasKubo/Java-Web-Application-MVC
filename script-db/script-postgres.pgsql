INSERT INTO pessoas (nome,cep,endereco,renda,situacao,telefone) 
VALUES ('José',05595030,'Rua Desembargador Júlio César de Faria',1212,1,'(55) 2305-1533');

INSERT INTO pessoasfisicas (id,cpf,data_nascto)
VALUES (1,'26060165052','1990-10-23');

SELECT * FROM pessoas;
SELECT * FROM pessoasfisicas;

DELETE FROM pessoas WHERE id=2;