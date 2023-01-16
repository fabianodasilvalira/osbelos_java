create table comentarios (
	id bigint not null AUTO_INCREMENT,
	usuario_id INT(11) NOT NULL,
	postagem_id INT(11) NOT NULL,
	comentario VARCHAR(250) NOT NULL,
	data DATETIME NOT NULL,
	status VARCHAR(10) NOT NULL,
	PRIMARY KEY (id)
);




