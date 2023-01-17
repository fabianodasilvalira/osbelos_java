create table usuarios(

id bigint not null AUTO_INCREMENT,
nome VARCHAR(150) NOT NULL,
url_foto VARCHAR(150) NOT NULL,
bebidas_alcoolicas VARCHAR(10) NOT NULL,
bebida_predileta VARCHAR(150) NOT NULL,
contato VARCHAR(20) NOT NULL,
login VARCHAR(100) NOT NULL,
senha VARCHAR(255) NOT NULL,
data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
status VARCHAR(10) NOT NULL,

PRIMARY KEY (id)
);

INSERT INTO osbelos.usuarios (nome, url_foto, bebidas_alcoolicas, bebida_predileta, contato, login, senha, status) 
VALUES ('Fabiano', 'http//qualquercoisa', 'SIM', 'CERVEJA', '86998181489', 'fabianolira', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', '1');
