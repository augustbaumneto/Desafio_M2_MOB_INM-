CREATE TABLE tb_tipo_cenario (
  vchar_tipo    VARCHAR(6)       PRIMARY KEY NOT NULL,
  int_seq     INTEGER
);
INSERT INTO tb_tipo_cenario(vchar_tipo, int_seq) VALUES ('padrão',1);
INSERT INTO tb_tipo_cenario(vchar_tipo, int_seq) VALUES ('esquema',2);
CREATE TABLE tb_tipo_status (
  vchar_tipo_status    VARCHAR(6) PRIMARY KEY NOT NULL,
  int_seq     INTEGER
);
INSERT INTO tb_tipo_status(vchar_tipo_status, int_seq) VALUES ('Passou',1);
INSERT INTO tb_tipo_status(vchar_tipo_status, int_seq) VALUES ('Falhou',2);
INSERT INTO tb_tipo_status(vchar_tipo_status, int_seq) VALUES ('Erro',3);
Create table tb_Suite_Execucao (
	int_id_suite INTEGER primary key autoincrement not null,
	dt_inicio_execucao_suite DATETIME,
    dt_fim_execucao_suite DATETIME,
    arq_log_execucao LONGBLOB
);
Create table tb_Resultado_Execucao (
	int_id_execucao INTEGER primary key autoincrement not null,
    int_id_suite INTEGER,
    enum_tipo_cenario VARCHAR(6) REFERENCES tb_tipo_cenario(vchar_tipo),
    vchar_cenario VARCHAR(200),
    vchar_exemplo VARCHAR(100),
    dt_inicio_execucao DATETIME,
    dt_fim_execucao DATETIME,
    enum_status VARCHAR(6) REFERENCES tb_tipo_status(vchar_tipo_status),
    arq_evidencia LONGBLOB,
    foreign key (int_id_suite)
		References tb_Suite_Execucao(int_id_suite)
);
Create table tb_Massa_Execucao (
	int_id_massa INTEGER primary key autoincrement not null,
    int_id_execucao INTEGER,
    vchar_tipo_massa VARCHAR(50),
    vchar_valor_massa VARCHAR(100),
    foreign key (int_id_execucao)
		References tb_Resultado_Execucao(int_id_execucao)
);


