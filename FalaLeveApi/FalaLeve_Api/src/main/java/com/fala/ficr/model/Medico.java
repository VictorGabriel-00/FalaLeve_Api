package com.fala.ficr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_MEDICO")
public class Medico extends Usuario {
    private String Crm;

    public String getCrm() {
        return Crm;
    }
    public void setCrm(String crm) {
        this.Crm = crm;
    }

    @Override
    public String toString(){
        return "CRM: " + getCrm();
    }

}
