package model;

import controller.GerarIdMedico;

public class Medico extends Usuario {
    GerarIdMedico gerarIdMedico = new GerarIdMedico();



    private int crm;


    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }


}
