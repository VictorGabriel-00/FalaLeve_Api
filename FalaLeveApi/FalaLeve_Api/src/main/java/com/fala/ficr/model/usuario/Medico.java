package com.fala.ficr.model.usuario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.UUID;


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

}
