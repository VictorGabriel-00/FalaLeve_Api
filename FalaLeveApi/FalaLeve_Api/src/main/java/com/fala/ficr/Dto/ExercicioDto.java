package com.fala.ficr.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExercicioDto(@NotBlank String titulo, @NotBlank String descricao, @NotNull int nivelDificuldade,
                           @NotNull int xpGanho, @NotBlank String nomeExercicio, @NotBlank String descricaoExercicio,
                           @NotBlank String tipoExercicio, @NotBlank String instrucaoExercicio, @NotNull int tempoExercicio,
                           @NotBlank String categoria, @NotBlank String disponibilidade) {
}
