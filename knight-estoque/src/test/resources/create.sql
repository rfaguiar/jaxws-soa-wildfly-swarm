
CREATE TABLE IF NOT EXISTS `autor` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `livro` (
	`id` int(11) NOT NULL,
	`nome` varchar(255) DEFAULT NULL,
	`editora` varchar(255) DEFAULT NULL,
	`ano_publicacao` int(11) DEFAULT NULL,
	`resumo` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `livro_autor` (
	`id_livro` int(11) NOT NULL,
	`id_autor` int(11) NOT NULL,
	foreign key (id_livro) references livro(id),
	foreign key (id_autor) references autor(id)
);