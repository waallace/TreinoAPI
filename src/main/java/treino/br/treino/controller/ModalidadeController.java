package treino.br.treino.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import treino.br.treino.Modalidades.DadosCadastroModalidade;
import treino.br.treino.Modalidades.DadosDetalhamentosModalidade;
import treino.br.treino.Modalidades.Modalidades;
import treino.br.treino.Modalidades.ModalidadesRepository;

@RestController
@RequestMapping("/modalidades")
public class ModalidadeController {
    @Autowired
    private ModalidadesRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroModalidade dados) {

        var modalidades = new Modalidades(dados);
        repository.save(modalidades);
    }


    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentosModalidade>> list(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentosModalidade::new);
        return ResponseEntity.ok(page);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity autualizar(@PathVariable Long id, @RequestBody @Valid DadosCadastroModalidade dados) {

        var modalidades = repository.getReferenceById(id);
        modalidades.AtualizarInformacoesModalidade(dados);

        return ResponseEntity.ok(new DadosDetalhamentosModalidade(modalidades));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        var modalidade = repository.getReferenceById(id);
        modalidade.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var modalidade = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentosModalidade(modalidade));

    }
}
