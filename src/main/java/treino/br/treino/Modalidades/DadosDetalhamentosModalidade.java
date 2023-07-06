package treino.br.treino.Modalidades;

import java.math.BigDecimal;

public record DadosDetalhamentosModalidade(Long id, String nome, BigDecimal mensalidade, String descricao) {


    public DadosDetalhamentosModalidade(Modalidades modalidades) {
        this(modalidades.getId(), modalidades.getNome(), modalidades.getMensalidade(), modalidades.getDescricao());
    }
}
