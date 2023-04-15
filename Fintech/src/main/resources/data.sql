INSERT INTO cliente (cpf, nome, renda_Mensal, cep, logradouro, numero,quantidade_emprestimo, bairro, cidade, uf)
VALUES (98765432109, 'Maria Oliveira', 3000.00, '01310-100', 'Avenida Paulista', 500,0,'Bela Vista', 'São Paulo', 'SP');

INSERT INTO cliente (cpf, nome, renda_Mensal, cep, logradouro, numero,quantidade_emprestimo, bairro, cidade, uf)
VALUES (11122233344, 'Pedro Santos', 8000.00, '22460-030', 'Rua das Palmeiras', 200,0 ,'Jardim Botânico', 'Rio de Janeiro', 'RJ');

INSERT INTO cliente (cpf, nome, renda_Mensal, cep, logradouro, numero,quantidade_emprestimo, bairro, cidade, uf)
VALUES (99988877766, 'José Silva', 6000.00, '01430-000', 'Avenida Brasil', 1000,0, 'Jardim América', 'São Paulo', 'SP');

INSERT INTO emprestimos ( data_Final, data_Inicial, relacionamento,valor_final,valor_Inicial,cpf_Cliente)
VALUES ('2022-10-01', '2022-09-01','OURO',15000,5000, 11122233344);

INSERT INTO emprestimos ( data_Final, data_Inicial, relacionamento,valor_final,valor_Inicial,cpf_Cliente)
VALUES ('2022-11-01', '2022-09-01','PRATA',25000,1000, 11122233344);

INSERT INTO emprestimos ( data_Final, data_Inicial, relacionamento,valor_final,valor_Inicial,cpf_Cliente)
VALUES ('2022-10-01', '2022-11-30','BRONZE',5000,1000, 98765432109);





