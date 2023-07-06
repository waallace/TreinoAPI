package treino.br.treino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import treino.br.treino.Professor.ProfessorRepository;
import treino.br.treino.Professor.ProfessoresDTO;
import treino.br.treino.cliente.ClienteRepository;
import treino.br.treino.cliente.ClientesDTO;

@RestController
@RequestMapping("/professores_clientes")
public class RelacionamentoClienteProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private ClienteRepository clienteRepository;


    public RelacionamentoClienteProfessorController(ProfessorRepository professorRepository, ClienteRepository clienteRepository) {

        this.professorRepository = professorRepository;
        this.clienteRepository = clienteRepository;

    }

    @GetMapping("professor/{professorId}/clientes")
    public ProfessoresDTO getProfessorComCliente(@PathVariable Long professorId) {
        var professor = professorRepository.findById(professorId).orElse(null);
        return new ProfessoresDTO(professor);
    }

    @GetMapping("/cliente/{clienteId}/professores")
    public ClientesDTO getClienteComProfessor(@PathVariable Long clienteId) {
        var clientes = clienteRepository.findById(clienteId).orElse(null);
        return new ClientesDTO(clientes);
    }
}
