CREATE DATABASE MetalurgiaDB;
USE MetalurgiaDB;
CREATE TABLE Usuarios (
    id_usuario BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    usuario VARCHAR(75) UNIQUE NOT NULL,
    senha VARCHAR(150) NOT NULL,
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Ferramentas (
    id_ferramenta BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    quantidade INT DEFAULT 0,
    preco DECIMAL(10, 2),
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Movimentacao (
    id_movimentacao BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_ferramenta BIGINT,
    id_usuario BIGINT,
    tipo_movimentacao ENUM('entrada', 'saida') NOT NULL,
    quantidade INT NOT NULL,
    data_movimentacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    observacoes TEXT,
    FOREIGN KEY (id_ferramenta) REFERENCES Ferramentas(id_ferramenta),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);
INSERT INTO Usuarios (nome, senha) VALUES ('admin', '1234');
UPDATE usuarios
SET usuario = "Administrador"
WHERE id_usuario = 1

