package com.fala.ficr.Dto;



import jakarta.validation.constraints.NotBlank;


public record MedicoRecordDto(@NotBlank String nome, @NotBlank String email,@NotBlank String DataNascimento,@NotBlank String Crm) {
}
