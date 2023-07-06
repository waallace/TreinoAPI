package treino.br.treino.Modalidades;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroModalidade(

        @NotBlank
        String nome,

        @NotNull
        BigDecimal mensalidade,

        @NotBlank
        String descricao) {
}
