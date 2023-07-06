package treino.br.treino.Modalidades;

import jakarta.persistence.*;
import lombok.*;
<<<<<<< HEAD
import treino.br.treino.Professor.Professor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
=======

import java.math.BigDecimal;
>>>>>>> c095edda66c3a5a394b8e0237c473729557b7238

@Table(name = "Modalidades")
@Entity(name = "Modalidade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Modalidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
<<<<<<< HEAD

    //Relação de tabela de professor e modalidades
    @ManyToMany
    @JoinTable(name = "modalidades_professores",
            joinColumns = @JoinColumn(name = "modalidade_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professores = new ArrayList<>();
    //
=======
>>>>>>> c095edda66c3a5a394b8e0237c473729557b7238
    private boolean ativo;
    private String nome;
    private BigDecimal mensalidade;
    private String descricao;

    public Modalidades(DadosCadastroModalidade dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.mensalidade = dados.mensalidade();
        this.descricao = dados.descricao();
    }


    public void AtualizarInformacoesModalidade(DadosCadastroModalidade dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.mensalidade() != null) {
            this.mensalidade = dados.mensalidade();
        }

        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
