package com.fala.ficr.Dto;

import com.fala.ficr.model.licao.Licao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExercicioDto(@NotBlank String nomeExercicio,@NotBlank String descricaoExercicio,@NotBlank String tipoExercicio,
                           String instrucaoExercicio, int tempoExercicio,
                           @NotNull
                           @Valid
                           Licao licao ) {
}
