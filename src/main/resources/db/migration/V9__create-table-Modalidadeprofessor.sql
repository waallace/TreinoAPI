CREATE TABLE modalidades_professores(
  modalidade_id INT,
  professor_id INT,
  PRIMARY KEY (modalidade_id, professor_id),
  FOREIGN KEY (modalidade_id) REFERENCES modalidade(modalidade_id),
  FOREIGN KEY (professor_id) REFERENCES professor(professor_id)
);