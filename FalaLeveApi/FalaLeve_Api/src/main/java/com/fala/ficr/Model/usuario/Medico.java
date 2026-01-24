package com.fala.ficr.Model.usuario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "TB_MEDICO")
@JsonPropertyOrder({ "id","idMedico", "nome", "email", "dataNascimento", "Crm" })
public class Medico extends Usuario {

    private String Crm;

    public String getCrm() {
        return Crm;
    }
    public void setCrm(String crm) {
        this.Crm = crm;
    }

    @OneToMany(mappedBy = "medico", fetch = FetchType.EAGER)
    private List<PacienteNaoVerbal> pacientes = new ArrayList<>();

    public List<PacienteNaoVerbal> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteNaoVerbal> pacientes) {
        this.pacientes = pacientes;
    }
}
