create table postagens (
	id bigint not null AUTO_INCREMENT,
	usuario_id INT(11) NOT NULL,
	url_postagem VARCHAR(250) NOT NULL,
	legenda VARCHAR(250) NOT NULL,
	data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	status VARCHAR(10) NOT NULL,
	PRIMARY KEY (id)
	
);


