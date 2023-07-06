package treino.br.treino.cliente;

import treino.br.treino.Endereco.Endereco;

public record DadosDetalhentosCliente(Long id, String nome, String email, String cpf, String telefone,
                                      Nivel nivel, Endereco endereco) {

    public DadosDetalhentosCliente(Cliente cliente){
           this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getTelefone(), cliente.getNivel(), cliente.getEndereco());
    }
}
