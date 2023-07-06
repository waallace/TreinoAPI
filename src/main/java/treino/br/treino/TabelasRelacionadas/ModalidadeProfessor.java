package treino.br.treino.TabelasRelacionadas;

import org.springframework.stereotype.Service;
import treino.br.treino.Modalidades.Modalidades;
import treino.br.treino.Modalidades.ModalidadesRepository;
import treino.br.treino.Professor.Professor;
import treino.br.treino.Professor.ProfessorRepository;

@Service
public class ModalidadeProfessor {

    private ModalidadesRepository modalidadesRepository;
    private ProfessorRepository professorRepository;


    public ModalidadeProfessor(ModalidadesRepository modalidadesRepository, ProfessorRepository professorRepository) {

        this.modalidadesRepository = modalidadesRepository;
        this.professorRepository = professorRepository;
    }


    public void adicionarProfessorParaModalidade(Long ModalidadeId, Long ProfessorId) {

        Modalidades modalidades = modalidadesRepository.findById(ModalidadeId)
                .orElseThrow(() -> new IllegalArgumentException("Modalidade Não Encontrada"));

        Professor professor = professorRepository.findById(ProfessorId)
                .orElseThrow(() -> new IllegalArgumentException("Professor Não Encontrado"));


        modalidades.getProfessores().add(professor);
        professor.getModalidades().add(modalidades);

        modalidadesRepository.save(modalidades);
        professorRepository.save(professor);
    }
}
