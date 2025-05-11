package model;

import controller.GerarIdMedico;

public class Medico extends Usuario {
    GerarIdMedico gerarIdMedico = new GerarIdMedico();
    @Override
    public String escolha(String ump) {

        return escolha(ump);
    }

    private int crm;


    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }


}
