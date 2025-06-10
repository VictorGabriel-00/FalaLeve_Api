package com.fala.ficr.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioNaoVerbalDto(@NotBlank String nome, @NotBlank String email, @NotBlank String senha,
                                  @NotBlank String DataNascimento, @NotNull int grau,@NotNull int fonteTamanho,
                                  @NotBlank String cor,@NotBlank String animacao,@NotBlank String son){
}
