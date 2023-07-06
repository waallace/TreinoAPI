package treino.br.treino.Professor;

import jakarta.persistence.*;
import lombok.*;
import treino.br.treino.Endereco.Endereco;
import treino.br.treino.Modalidades.Modalidades;
import treino.br.treino.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;


@Table(name = "Professores")
@Entity(name = "Professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relação de tabela professor e clientes
    @ManyToMany
    @JoinTable(name = "clientes_professores",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes = new ArrayList<>();

    //Relação de tabela professor e modalidade
    @ManyToMany(mappedBy = "professores")
    private List<Modalidades> modalidades = new ArrayList<>();
    //
    private boolean ativo;
    String nome;
    String email;
    String cpf;
    String telefone;
    //    @Enumerated(EnumType.STRING)
//    private Modalidade modalidade;
    @Embedded
    private Endereco endereco;

    public Professor(DadosCadastroProfessor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
//        this.modalidade = dados.modalidade();
        this.endereco = new Endereco(dados.dadosEndereco());
    }

    public void AutializarInformacao(DadosCadastroProfessor dados) {

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
