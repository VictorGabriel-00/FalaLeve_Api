CREATE TABLE Usuario (
                         usuario_id SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         senha VARCHAR(255) NOT NULL,
                         tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('paciente', 'cuidador', 'medico')),
                         data_nascimento DATE,
                         grau_necessidade INT CHECK (grau_necessidade BETWEEN 1 AND 5),
                         pontos INT DEFAULT 0,
                         nivel INT DEFAULT 1,
                         config VARCHAR(500),
                         criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         ultimo_acesso TIMESTAMP,
                         ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE Licao (
                       licao_id SERIAL PRIMARY KEY,
                       titulo VARCHAR(100) NOT NULL,
                       descricao VARCHAR(250),
                       nivel_dificuldade INT NOT NULL CHECK(nivel_dificuldade BETWEEN 1 AND 5),
                       xp_recompensa INT NOT NULL,
                       categoria VARCHAR(50),
                       tempo_estimado INT,
                       disponivel BOOLEAN DEFAULT TRUE
);

CREATE TABLE Exercicio (
                           exercicio_id SERIAL PRIMARY KEY,
                           licao_id INT NOT NULL REFERENCES Licao(licao_id),
                           titulo VARCHAR(100) NOT NULL,
                           descricao VARCHAR(250) NOT NULL,
                           tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('multipla_escolha', 'arrastar_soltar', 'associacao', 'voz')),
                           instrucoes VARCHAR(500),
                           tempo_estimado INT
);

CREATE TABLE Progresso (
                           progresso_id SERIAL PRIMARY KEY,
                           usuario_id INT NOT NULL REFERENCES Usuario(usuario_id),
                           licao_id INT NOT NULL REFERENCES Licao(licao_id),
                           data_inicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           data_conclusao TIMESTAMP,
                           percentual_completo DECIMAL(5,2) DEFAULT 0.00 CHECK(percentual_completo BETWEEN 0 AND 100),
                           xp_ganho INT DEFAULT 0
);

-- Ajuste para a sequência começar em 1000 e incrementar de 10 em 10
ALTER SEQUENCE progresso_progresso_id_seq RESTART WITH 1000 INCREMENT BY 10;

CREATE TABLE Recompensa(
                           recompensa_id SERIAL PRIMARY KEY,
                           progresso_id INT NOT NULL REFERENCES Progresso(progresso_id),
                           usuario_id INT NOT NULL REFERENCES Usuario(usuario_id),
                           tipo VARCHAR(20) NOT NULL CHECK (tipo IN('emoji','fundo_tela','avatar','badge','pontos_extra')),
                           valor INT NOT NULL,
                           descricao VARCHAR(255),
                           data_concessao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           data_resgate TIMESTAMP,
                           resgatado BOOLEAN DEFAULT FALSE
);

CREATE TABLE Comunicacao(
                            comunicacao_id SERIAL PRIMARY KEY,
                            usuario_id INT NOT NULL UNIQUE REFERENCES Usuario(usuario_id),
                            data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Simbolo (
                         simbolo_id SERIAL PRIMARY KEY,
                         texto VARCHAR(100) NOT NULL,
                         categoria VARCHAR(50) NOT NULL,
                         caminho_imagem VARCHAR(255) NOT NULL,
                         caminho_audio VARCHAR(255),
                         tags VARCHAR(255)
);

CREATE TABLE Comunicacao_Simbolo (
                                     comunicacao_id INT NOT NULL REFERENCES Comunicacao(comunicacao_id) ON DELETE CASCADE,
                                     simbolo_id INT NOT NULL REFERENCES Simbolo(simbolo_id),
                                     frequencia_uso INT DEFAULT 0,
                                     eh_principal BOOLEAN DEFAULT FALSE,
                                     ordem INT,
                                     PRIMARY KEY (comunicacao_id, simbolo_id)
);
