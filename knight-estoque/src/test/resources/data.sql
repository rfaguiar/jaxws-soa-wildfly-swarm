
DELETE FROM autor;
DELETE FROM livro_autor;
DELETE FROM livro;
--autor
INSERT INTO autor(id, nome, data_nascimento) VALUES (1, 'Adriano Almeida', '18-06-12');
INSERT INTO autor(id, nome, data_nascimento) VALUES (2, 'Paulo Silveira', '18-06-12');
INSERT INTO autor(id, nome, data_nascimento) VALUES (3, 'Vinicius Baggio', '18-06-12');
--livro
INSERT INTO livro(id, nome, editora, ano_publicacao, resumo) VALUES (1, 'Guia do Programador', 'Casa do Código', 2012, 'Vá do "nunca programei" ...');
INSERT INTO livro(id, nome, editora, ano_publicacao, resumo) VALUES (2, 'Ruby on Rails', 'Casa do Código', 2012, 'Crie rapidamente aplicações web');
--livro_autor
INSERT INTO livro_autor(id_livro, id_autor) VALUES(1, 1);
INSERT INTO livro_autor(id_livro, id_autor) VALUES(1, 2);
INSERT INTO livro_autor(id_livro, id_autor) VALUES(2, 3);