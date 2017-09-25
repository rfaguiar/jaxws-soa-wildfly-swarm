
CREATE TABLE IF NOT EXISTS `usuario` (`id` int(11) NOT NULL, `nome` varchar(255) DEFAULT NULL, `login` varchar(255) DEFAULT NULL, `senha` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`));

insert into usuario (id, nome, login, senha) values (1, 'Alexandre','admin','admin');
insert into usuario (id, nome,login,senha) values (2, 'Rafael','rafael','rafael');
insert into usuario (id, nome,login,senha) values (3, 'Paulo','paulo','paulo');
insert into usuario (id, nome,login,senha) values (4, 'Adriano','adriano','adriano');
insert into usuario (id, nome,login,senha) values (5, 'Matheus','matheus','matheus');
