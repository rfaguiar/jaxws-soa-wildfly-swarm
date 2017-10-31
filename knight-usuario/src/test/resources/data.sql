
DELETE FROM usuario;
DELETE FROM imagen;
DELETE FROM telefone;
INSERT INTO usuario(id, nome, login, senha) VALUES(1, 'Alexandre', 'admin', 'admin');
INSERT INTO usuario(id, nome, login, senha) VALUES(2, 'Admin', 'admin', 'admin');
INSERT INTO telefone(id, tipo, numero, usuario_id) VALUES(1, 'TEL', 123456789, 2);
INSERT INTO telefone(id, tipo, numero, usuario_id) VALUES(2, 'CEL', 987564321, 2);