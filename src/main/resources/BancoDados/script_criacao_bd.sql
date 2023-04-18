Create table tb_Suite_Execucao (
	bint_id_suite INTEGER primary key autoincrement,
	dt_inicio_execucao_suite DATETIME,
    dt_fim_execucao_suite DATETIME,
    arq_log_execucao LONGBLOB
);
Create table tb_Resultado_Execucao (
	bint_id_execucao INTEGER primary key autoincrement,
    bint_id_suite INTEGER,
    enum_tipo_cenario ENUM ('padrão','esquema'),
    vchar_cenario VARCHAR(200),
    vchar_exemplo VARCHAR(100),
    dt_inicio_execucao DATETIME,
    dt_fim_execucao DATETIME,
    enum_status ENUM ('Passou','Falhou','Erro'),
    arq_evidencia LONGBLOB,
    foreign key (bint_id_suite)
		References tb_Suite_Execucao(bint_id_suite)
);
Create table tb_Massa_Execucao (
	bint_id_massa INTEGER primary key autoincrement,
    bint_id_execucao INTEGER,
    vchar_tipo_massa VARCHAR(50),
    vchar_valor_massa VARCHAR(100),
    foreign key (bint_id_execucao)
		References tb_Resultado_Execucao(bint_id_execucao)
);


