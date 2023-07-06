package treino.br.treino.Professor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import treino.br.treino.Endereco.DadosEndereco;

public record DadosCadastroProfessor(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotBlank
        String telefone,

//        @NotNull
//        Modalidade modalidade,
        Long modalidadeId,
        @NotNull
        @Valid
        DadosEndereco dadosEndereco) {


}
