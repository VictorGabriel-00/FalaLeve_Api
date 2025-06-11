package com.fala.ficr.model.licao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EXERCICIO")
public class Exercicio extends Licao{
    //private int idExercicio;
    private String nomeExercicio;
    private String descricaoExercicio;
    private String tipoExercicio;
    private String instrucaoExercicio;
    private int tempoExercicio;


    /*public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }*/

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
    }

    public String getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(String tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    public String getInstrucaoExercicio() {
        return instrucaoExercicio;
    }

    public void setInstrucaoExercicio(String instrucaoExercicio) {
        this.instrucaoExercicio = instrucaoExercicio;
    }

    public int getTempoExercicio() {
        return tempoExercicio;
    }

    public void setTempoExercicio(int tempoExercicio) {
        this.tempoExercicio = tempoExercicio;
    }
}
