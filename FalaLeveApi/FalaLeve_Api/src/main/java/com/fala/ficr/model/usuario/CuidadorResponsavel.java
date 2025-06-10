package com.fala.ficr.model.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PARENTE_RESPONSAVEL")
public class CuidadorResponsavel extends Usuario {

    private String emailParente;
    private String senhaParente;
    private String nomeParente;
    private String dataNascimentoParente;

    public String getEmailParente() {
        return emailParente;
    }

    public void setEmailParente(String emailParente) {
        this.emailParente = emailParente;
    }

    public void setSenhaParente(String senhaParente) {
        this.senhaParente = senhaParente;
    }

    public String getNomeParente() {
        return nomeParente;
    }

    public void setNomeParente(String nomeParente) {
        this.nomeParente = nomeParente;
    }

    public String getDataNascimentoParente() {
        return dataNascimentoParente;
    }

    public void setDataNascimentoParente(String dataNascimentoParente) {
        this.dataNascimentoParente = dataNascimentoParente;
    }



}
