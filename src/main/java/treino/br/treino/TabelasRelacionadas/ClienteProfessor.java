package treino.br.treino.TabelasRelacionadas;


import org.springframework.stereotype.Service;
import treino.br.treino.Professor.Professor;
import treino.br.treino.Professor.ProfessorRepository;
import treino.br.treino.cliente.Cliente;
import treino.br.treino.cliente.ClienteRepository;


@Service
public class ClienteProfessor {

    private ProfessorRepository professorRepository;
    private ClienteRepository clienteRepository;

    public ClienteProfessor(ProfessorRepository professorRepository, ClienteRepository clienteRepository) {

        this.professorRepository = professorRepository;
        this.clienteRepository = clienteRepository;
    }

    public void adicionarClienteAoProfessor(Long ProfessorId, Long ClienteId) {

        Professor professor = professorRepository.findById(ProfessorId)
                .orElseThrow(() -> new IllegalArgumentException("Professor Não Encontrado"));

        Cliente cliente = clienteRepository.findById(ClienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente Não Encontrado"));

        professor.getClientes().add(cliente);
        cliente.getProfessores().add(professor);

        professorRepository.save(professor);
        clienteRepository.save(cliente);
    }
}
