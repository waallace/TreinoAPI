package treino.br.treino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import treino.br.treino.Modalidades.ModalidadesDTO;
import treino.br.treino.Modalidades.ModalidadesRepository;
import treino.br.treino.Professor.ProfessorRepository;
import treino.br.treino.Professor.ProfessoresDTO;

@RestController
@RequestMapping("/modalidade_professor")
public class RelacionamentoProfessorModalidadeController {
    @Autowired
    private ModalidadesRepository modalidadesRepository;
    @Autowired
    private ProfessorRepository professorRepository;


    public RelacionamentoProfessorModalidadeController(ModalidadesRepository modalidadesRepository, ProfessorRepository professorRepository) {

        this.modalidadesRepository = modalidadesRepository;
        this.professorRepository = professorRepository;
    }

    @GetMapping("/modalidade/{modalidadeId}/professor")
    public ModalidadesDTO getProfessorComModalidade(@PathVariable Long modalidadeId) {
        var modalidade = modalidadesRepository.findById(modalidadeId).orElse(null);
        return new ModalidadesDTO(modalidade);
    }

    @GetMapping("/professor/{professorId}/modalidade")
    public ProfessoresDTO getModalidadeComProfessor(@PathVariable Long professorId) {
        var professor = professorRepository.findById(professorId).orElse(null);
        return new ProfessoresDTO(professor);
    }
}
