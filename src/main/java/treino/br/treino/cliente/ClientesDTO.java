package treino.br.treino.cliente;

import treino.br.treino.Endereco.Endereco;
import treino.br.treino.Professor.DadosDetalhamentoProfessor;

import java.util.List;

public record ClientesDTO(Long id,
                          String nome,
                          String email,
                          String cpf,
                          Nivel nivel,
                          Endereco endereco,
                          List<DadosDetalhamentoProfessor> professores) {

    public ClientesDTO(Cliente cliente) {

        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(),
                cliente.getNivel(), cliente.getEndereco(), cliente.getProfessores().stream().
                        map(professor -> new DadosDetalhamentoProfessor(professor)).toList());
    }
}
