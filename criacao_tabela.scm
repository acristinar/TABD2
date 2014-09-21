CREATE TABLE funcionario
(
  cpf integer NOT NULL,
  nome text NOT NULL,
  tipo text NOT NULL,
  CONSTRAINT funcionario_pkey PRIMARY KEY (cpf)
)