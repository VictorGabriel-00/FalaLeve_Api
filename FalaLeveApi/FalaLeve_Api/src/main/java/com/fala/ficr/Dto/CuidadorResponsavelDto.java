package com.fala.ficr.Dto;

import jakarta.validation.constraints.NotBlank;

public record CuidadorResponsavelDto(@NotBlank String nome, @NotBlank String email, @NotBlank String senha,
                                     @NotBlank String DataNascimento, @NotBlank String emailParente, @NotBlank String senhaParente,
                                     @NotBlank String nomeParente, @NotBlank String dataNascimentoParente) {
}
