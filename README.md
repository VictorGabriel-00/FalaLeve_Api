# FalaLeve API

## 📝 Sumário

* [Sobre o Projeto](#-sobre-o-projeto)
* [Funcionalidades Principais](#-funcionalidades-principais)
* [Modelo de Negócio](#-modelo-de-negócio)
* [Estrutura do Banco de Dados](#-estrutura-do-banco-de-dados)
* [Tecnologias Utilizadas](#-tecnologias-utilizadas)
* [Como Executar a API](#-como-executar-a-api)
* [Colaboradores](#-colaboradores)
* [Licença](#-licença)

---

## 🎯 Sobre o Projeto

O **FalaLeve** é uma solução de tecnologia assistiva que atua como apoio complementar às terapias existentes para pessoas com dificuldades de comunicação (como autismo, afasia e paralisia cerebral). O objetivo é oferecer uma ferramenta robusta que garanta um acompanhamento eficaz e adaptado ao desenvolvimento de cada indivíduo, facilitando sua independência e organização diária.

Este repositório contém o código-fonte da **API RESTful**, que serve como o backend da plataforma, responsável por toda a lógica de negócio, gerenciamento de dados e comunicação com o banco de dados.

O planejamento e a gestão do projeto podem ser acompanhados através do nosso [**Trello Board**](https://trello.com/invite/b/67e3f25e9e44a0285bb824dc/ATTla9e4220e069887a95074f1de33eef050E31B1AA6/falaleve).

## ✨ Funcionalidades Principais

Com base em um levantamento detalhado com usuários e especialistas, as funcionalidades essenciais da API incluem:

* **🗣️ Sistema de Comunicação Adaptável:**
    * Gerenciamento de um banco de símbolos (pictogramas) personalizável por usuário.
    * Permite a combinação de símbolos para a formação de frases.
    * Interface intuitiva para seleção e uso rápido dos símbolos.

* **🧠 Módulo de Aprendizagem e Exercícios:**
    * Estrutura hierárquica de lições e exercícios com níveis de dificuldade progressivos.
    * Conteúdo que se adapta com base no progresso do usuário.
    * Suporte a diferentes tipos de exercícios (múltipla escolha, arrastar e soltar, associação).

* **👤 Gestão de Perfis Personalizáveis:**
    * Diferenciação entre tipos de usuários: **Paciente** e **Médico/Terapeuta**.
    * Configurações específicas e personalizadas para cada perfil.

* **📈 Sistema de Progresso e Recompensas:**
    * Rastreamento individualizado do desenvolvimento de cada usuário.
    * Registro de atividades concluídas, conquistas e XP (pontos de experiência).
    * Sistema de recompensas (badges, itens virtuais) para engajamento e motivação.

* **🔗 Compartilhamento com Cuidadores e Profissionais:**
    * Endpoints que permitem a visualização do progresso e das atividades do paciente por usuários autorizados (médicos).

## 💼 Modelo de Negócio

* **Mercado Alvo:** Pessoas com dificuldades de comunicação, seus familiares, cuidadores e profissionais de saúde (fonoaudiólogos, terapeutas ocupacionais).
* **Modelo de Receita:**
    * **Freemium:** Versão gratuita com funcionalidades básicas.
    * **Premium:** Assinatura para acesso a recursos avançados e personalização.
    * **B2B:** Licenciamento para instituições de ensino e saúde.

## 🗄️ Estrutura do Banco de Dados

A arquitetura de dados foi modelada para suportar todas as funcionalidades da plataforma de forma relacional e escalável, utilizando PostgreSQL. O modelo agora centraliza as informações de perfis na tabela `Usuario` com um campo `tipo` para diferenciação.

<details>
<summary><strong>Clique para ver o Schema SQL completo (Criação, Inserção e Automação)</strong></summary>

```sql
-- =================================================================
-- CRIAÇÃO DO BANCO E DAS TABELAS
-- =================================================================

CREATE DATABASE FalaLeve;

\c falaleve;

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

-- =================================================================
-- ALIMENTAÇÃO (INSERÇÃO DE DADOS INICIAIS)
-- =================================================================

-- Tabela Usuario
INSERT INTO Usuario (nome, email, senha, tipo, data_nascimento, grau_necessidade, pontos, nivel)
VALUES 
('Marcos Paulo', 'marcos@email.com', 'senha123', 'paciente', '1995-05-15', 3, 150, 2),
('Mariana Mendes', 'mariana@email.com', 'senha456', 'paciente', '1998-08-20', 2, 200, 3),
('Victor Gabriel', 'victor@email.com', 'senha789', 'cuidador', '1985-02-10', NULL, 0, 1),
('Raica Lira', 'raica@email.com', 'senha101', 'medico', '1980-11-25', NULL, 0, 1);

-- Tabela Licao
INSERT INTO Licao (titulo, descricao, nivel_dificuldade, xp_recompensa, categoria, tempo_estimado)
VALUES 
('Comunicação Básica', 'Aprenda a expressar necessidades básicas', 1, 10, 'Comunicação', 15),
('Cores Primárias', 'Identificação das cores básicas', 1, 15, 'Cores', 20),
('Rotina Diária', 'Sequência de atividades do dia a dia', 2, 20, 'Rotinas', 25);

-- Tabela Exercicio
INSERT INTO Exercicio (licao_id, titulo, descricao, tipo, instrucoes, tempo_estimado)
VALUES 
(1, 'Pedir Água', 'Selecionar símbolo para pedir água', 'multipla_escolha', 'Escolha o símbolo correto', 5),
(1, 'Pedir Comida', 'Selecionar símbolo para pedir comida', 'arrastar_soltar', 'Arraste para a área correta', 5),
(2, 'Identificar Vermelho', 'Associar objetos vermelhos', 'associacao', 'Ligue os pares corretos', 7);

-- Tabela Progresso
INSERT INTO Progresso (usuario_id, licao_id, data_conclusao, percentual_completo, xp_ganho)
VALUES 
(1, 1, CURRENT_TIMESTAMP, 100.00, 10),
(1, 2, CURRENT_TIMESTAMP, 80.00, 12),
(2, 1, CURRENT_TIMESTAMP, 100.00, 10),
(2, 3, NULL, 30.00, 6);

-- Tabela Recompensa
INSERT INTO Recompensa (progresso_id, usuario_id, tipo, valor, descricao)
VALUES 
(1000, 1, 'emoji', 50, 'Completou primeira lição'),
(1000, 1, 'pontos_extra', 10, 'Bônus por rápido aprendizado'),
(1010, 2, 'badge', 1, 'Comunicador iniciante');

-- Tabela Comunicacao
INSERT INTO Comunicacao (usuario_id)
VALUES (1), (2), (3);

-- Tabela Simbolo
INSERT INTO Simbolo (texto, categoria, caminho_imagem, caminho_audio, tags)
VALUES 
('Água', 'Bebidas', '/imagens/agua.png', '/sons/agua.mp3', 'bebida,sede'),
('Comida', 'Alimentos', '/imagens/comida.png', '/sons/comida.mp3', 'alimento,fome'),
('Banheiro', 'Necessidades', '/imagens/banheiro.png', '/sons/banheiro.mp3', 'wc,higiene');

-- Tabela Comunicacao_Simbolo
INSERT INTO Comunicacao_Simbolo (comunicacao_id, simbolo_id, frequencia_uso, eh_principal, ordem)
VALUES 
(1, 1, 5, TRUE, 1),
(1, 2, 10, FALSE, 2),
(2, 3, 15, TRUE, 1),
(2, 1, 20, TRUE, 1);

-- =================================================================
-- AUTOMAÇÃO (TRIGGERS, FUNCTIONS, INDEXES)
-- =================================================================

-- Trigger de Atualização de Nível do Usuário
CREATE OR REPLACE FUNCTION atualizaNivel()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.pontos <> OLD.pontos AND NEW.tipo = 'paciente' AND NEW.ativo THEN
        NEW.nivel := CASE
            WHEN NEW.pontos >= 1000 THEN 5
            WHEN NEW.pontos >= 500 THEN 4
            WHEN NEW.pontos >= 250 THEN 3
            WHEN NEW.pontos >= 100 THEN 2
            ELSE 1
        END;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER tr_atualizaNivel
BEFORE UPDATE ON Usuario
FOR EACH ROW
EXECUTE FUNCTION atualizaNivel();

-- Trigger de Atualização do Último Acesso
CREATE OR REPLACE FUNCTION atualizaUltimoAcesso()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE Usuario
    SET ultimo_acesso = CURRENT_TIMESTAMP
    FROM Comunicacao
    WHERE Usuario.usuario_id = Comunicacao.usuario_id
    AND Comunicacao.comunicacao_id = NEW.comunicacao_id;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER tr_atualizaUltimoAcesso
AFTER INSERT OR UPDATE ON Comunicacao_Simbolo
FOR EACH ROW
EXECUTE FUNCTION atualizaUltimoAcesso();

-- Function para Símbolo Mais Utilizado
CREATE OR REPLACE FUNCTION SP_SimboloMaisUtilizado()
RETURNS TABLE(simbolo VARCHAR(100), total_usos BIGINT) AS $$
BEGIN
    RETURN QUERY
    SELECT 
        S.texto AS simbolo,
        SUM(CS.frequencia_uso)::BIGINT AS total_usos
    FROM
        Comunicacao_Simbolo AS CS
    JOIN
        Simbolo S ON CS.simbolo_id = S.simbolo_id
    GROUP BY
        S.texto
    ORDER BY
        total_usos DESC
    LIMIT 1;
END;
$$ LANGUAGE plpgsql;

-- Function para Calcular XP Total
CREATE OR REPLACE FUNCTION F_CalcularXPTotal(p_usuario_id INT)
RETURNS INT AS $$
DECLARE
    total_xp INT;
BEGIN
    SELECT SUM(xp_ganho) INTO total_xp FROM Progresso WHERE usuario_id = p_usuario_id;
    RETURN total_xp;
END;
$$ LANGUAGE plpgsql;

-- Índice
CREATE INDEX in_Usuario_Ativo ON Usuario(nome, ativo);

```
</details>

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 24
* **Framework:** Spring Boot 3
* **Acesso a Dados:** Spring Data JPA
* **Banco de Dados:** PostgreSQL
* **Autenticação:** Spring Security + JWT
* **Build Tool:** Maven

## 🚀 Como Executar a API

Siga os passos abaixo para configurar e executar o projeto em seu ambiente local.

**Pré-requisitos:**
* JDK 24 ou superior.
* Maven 3.8 ou superior.
* Uma instância do PostgreSQL rodando.

**Instalação:**

1.  Clone o repositório:
    ```bash
    git clone [https://github.com/VictorGabriel-00/FalaLeve_Api.git](https://github.com/VictorGabriel-00/FalaLeve_Api.git)
    ```

2.  Acesse o diretório do projeto:
    ```bash
    cd FalaLeve_Api
    ```

3.  No seu PostgreSQL, crie o banco de dados:
    ```sql
    CREATE DATABASE FalaLeve;
    ```
    > **Nota:** Os scripts para criação de tabelas e inserção de dados serão executados automaticamente pelo Spring Boot se configurado adequadamente, ou você pode executá-los manualmente.

4.  Configure a conexão com o banco de dados no arquivo `application.properties` (localizado em `src/main/resources/`):
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/falaleve
    spring.datasource.username=[SEU_USUARIO]
    spring.datasource.password=[SUA_SENHA]
    spring.jpa.hibernate.ddl-auto=update
    ```

5.  Construa o projeto com o Maven:
    ```bash
    mvn clean install
    ```

6.  Execute a aplicação:
    ```bash
    mvn spring-boot:run
    ```

A API estará disponível por padrão em `http://localhost:8080`.

## 🤝 Colaboradores

Este projeto é o resultado do trabalho e da dedicação de uma equipe incrível. Conheça quem fez o **FalaLeve** acontecer:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/MariTronix">
        <img src="https://github.com/MariTronix.png" width="100px;" alt="Foto de Mariana Mendes no GitHub"/>
        <br />
        <sub><b>Mariana Mendes</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Marcopolojr360">
        <img src="https://github.com/Marcopolojr360.png" width="100px;" alt="Foto de Marcos Paulo no GitHub"/>
        <br />
        <sub><b>Marcos Paulo</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Raicalira">
        <img src="https://github.com/Raicalira.png" width="100px;" alt="Foto de Raica Lira no GitHub"/>
        <br />
        <sub><b>Raica Lira</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/VictorGabriel-00">
        <img src="https://github.com/VictorGabriel-00.png" width="100px;" alt="Foto de Victor Gabriel no GitHub"/>
        <br />
        <sub><b>Victor Gabriel</b></sub>
      </a>
    </td>
  </tr>
</table>

## 📜 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
