package treino.br.treino.Modalidades;

import treino.br.treino.Professor.DadosDetalhamentoProfessor;

import java.math.BigDecimal;
import java.util.List;

public record ModalidadesDTO(Long id,
                             String nome,
                             BigDecimal mensalidade,
                             String descricao,
                             List<DadosDetalhamentoProfessor> professores) {

    public ModalidadesDTO(Modalidades modalidades) {
        this(modalidades.getId(), modalidades.getNome(), modalidades.getMensalidade(), modalidades.getDescricao(),
                modalidades.getProfessores().stream().
                        map(professor -> new DadosDetalhamentoProfessor(professor)).toList());
    }
}
