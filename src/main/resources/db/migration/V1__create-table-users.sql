CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(20),
    numero VARCHAR(20),
    uf CHAR(2) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
