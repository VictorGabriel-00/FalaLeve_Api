package com.fala.ficr.model.usuario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_MEDICO")
@JsonPropertyOrder({ "idPersonalizado", "nome", "email", "dataNascimento", "Crm" })
public class Medico extends Usuario {

    private String Crm;

    @Column(name = "id_personalizado", unique = true)
    private String idPersonalizado;

    public String getIdPersonalizado() {
        return idPersonalizado;
    }

    public void setIdPersonalizado(String idPersonalizado) {
        this.idPersonalizado = idPersonalizado;
    }

    public String getCrm() {
        return Crm;
    }
    public void setCrm(String crm) {
        this.Crm = crm;
    }

}
