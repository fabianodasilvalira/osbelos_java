create table usuarios(

id bigint not null AUTO_INCREMENT,
nome VARCHAR(150) NOT NULL,
url_foto VARCHAR(150) NOT NULL,
bebidas_alcoolicas VARCHAR(10) NOT NULL,
bebida_predileta VARCHAR(150) NOT NULL,
contato VARCHAR(20) NOT NULL,
senha VARCHAR(50) NOT NULL,
data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
status VARCHAR(10) NOT NULL,

PRIMARY KEY (id)
);