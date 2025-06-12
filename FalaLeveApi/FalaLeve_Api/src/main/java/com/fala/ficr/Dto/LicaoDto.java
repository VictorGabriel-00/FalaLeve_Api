package com.fala.ficr.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LicaoDto(@NotBlank String titulo, String descricao, @NotNull int nivelDificuldade,
                       @NotNull int xpGanho, String categoria, int tempoEstimado,boolean disponibilidade) {
}
