package com.fala.ficr.Dto;

import com.fala.ficr.Model.usuario.Medico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteNaoVerbalDto(Medico medico,
                                   @NotBlank String nome,
                                   @NotBlank String email,
                                   @NotBlank String senha,
                                   @NotNull int grau,
                                   @NotBlank String cores,
                                   @NotBlank String sons){
}
