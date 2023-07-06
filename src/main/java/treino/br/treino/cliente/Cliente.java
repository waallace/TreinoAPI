package treino.br.treino.cliente;

import jakarta.persistence.*;
import lombok.*;
import treino.br.treino.Endereco.Endereco;
import treino.br.treino.Professor.Professor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Clientes")
@Entity(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Reclação de tabela de professor e clientes
    @ManyToMany(mappedBy = "clientes")
    private List<Professor> professores = new ArrayList();
    //
    private boolean ativo;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Nivel nivel;
    @Embedded
    private Endereco endereco;


    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.nivel = dados.nivel();
        this.endereco = new Endereco(dados.dadosEndereco());
    }

    public void AtualizarInformacoes(DadosCadastroCliente dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.email() != null) {
            this.email = dados.email();
        }

        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

        if (dados.dadosEndereco() != null) {
            this.endereco.AutualizarInformacoes(dados.dadosEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
