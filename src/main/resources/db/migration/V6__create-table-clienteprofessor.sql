CREATE TABLE clientes_professores(
  cliente_id INT,
  professor_id INT,
  PRIMARY KEY (cliente_id, professor_id),
  FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id),
  FOREIGN KEY (professor_id) REFERENCES professor(professor_id)
);