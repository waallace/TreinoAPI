package treino.br.treino.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import treino.br.treino.Modalidades.ModalidadesRepository;
import treino.br.treino.Professor.DadosCadastroProfessor;
import treino.br.treino.Professor.DadosDetalhamentoProfessor;
import treino.br.treino.Professor.Professor;
import treino.br.treino.Professor.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;
    @Autowired
    private ModalidadesRepository modalidadesRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroProfessor dados) {

        var professor = new Professor(dados);
        var modalide = modalidadesRepository.findById(dados.modalidadeId()).
                orElseThrow(() -> new RuntimeException("Modalidade ID não Econtrado"));
        modalide.getProfessores().add(professor);
        System.out.println("Salvando" + professor);
        repository.save(professor);

    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoProfessor>> list(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoProfessor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity autualizar(@PathVariable Long id, @RequestBody @Valid DadosCadastroProfessor dados) {

        var professor = repository.getReferenceById(id);
        professor.AutializarInformacao(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        var professor = repository.getReferenceById(id);
        professor.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var professor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }
}
