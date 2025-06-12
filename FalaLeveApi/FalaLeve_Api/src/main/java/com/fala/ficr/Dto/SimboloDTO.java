package com.fala.ficr.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SimboloDTO( @NotBlank String descricaoSimbolo, @NotBlank String categoriaSimbolo,
                             @NotBlank String URLImagemSimbolo, String URLaudioSimbolo,  String tagsSimbolo) {
}
