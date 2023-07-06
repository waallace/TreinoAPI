package treino.br.treino.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import treino.br.treino.Professor.ProfessorRepository;
import treino.br.treino.cliente.Cliente;
import treino.br.treino.cliente.ClienteRepository;
import treino.br.treino.cliente.DadosCadastroCliente;
import treino.br.treino.cliente.DadosDetalhentosCliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    ProfessorRepository professorRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroCliente dados) {

        var cliente = new Cliente(dados);
        var professor = professorRepository.findById(dados.professorId()).
                orElseThrow(() -> new RuntimeException("Professor ID Não Encontrado"));
        professor.getClientes().add(cliente);
        System.out.println("Salvando" + cliente);

        repository.save(cliente);


    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhentosCliente>> list(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosDetalhentosCliente::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosCadastroCliente dados) {

        var cliente = repository.getReferenceById(id);
        cliente.AtualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhentosCliente(cliente));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhentosCliente(cliente));
    }
}