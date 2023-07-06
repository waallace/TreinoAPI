package treino.br.treino.Professor;

import treino.br.treino.Endereco.Endereco;
import treino.br.treino.cliente.DadosDetalhentosCliente;

import java.util.List;

public record ProfessoresDTO(Long id,
                             String nome,
                             String email,
                             String cpf,
                             String telefone,
//                             Modalidade modalidade,
                             Endereco endereco,
                             List<DadosDetalhentosCliente> clientes) {

    public ProfessoresDTO(Professor professor) {
        this(professor.getId(), professor.nome, professor.cpf, professor.email, professor.telefone,
                professor.getEndereco(), professor.getClientes().stream().
                        map(cliente -> new DadosDetalhentosCliente(cliente)).toList());
    }

}
