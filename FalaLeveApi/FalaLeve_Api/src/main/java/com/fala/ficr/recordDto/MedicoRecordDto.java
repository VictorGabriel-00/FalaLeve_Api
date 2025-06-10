package com.fala.ficr.recordDto;



import jakarta.validation.constraints.NotBlank;


public record MedicoRecordDto(@NotBlank String nome, @NotBlank String email, @NotBlank String crm,@NotBlank String DataNascimento) {
}
