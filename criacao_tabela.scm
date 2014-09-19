CREATE TABLE "Funcionario"
(
  cpf integer NOT NULL,
  nome text NOT NULL,
  tipo text NOT NULL,
  CONSTRAINT "Funcionario_pkey" PRIMARY KEY (cpf)
)