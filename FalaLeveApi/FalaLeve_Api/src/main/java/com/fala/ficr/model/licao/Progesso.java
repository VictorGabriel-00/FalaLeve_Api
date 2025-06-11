package com.fala.ficr.model.licao;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PROGRESSO")
public class Progesso extends Licao {
    private double idProgresso;
    private int dataInicio;
    private int dataFim;
    private int xpGanho;
    private int percente;

    public double getIdProgresso() {
        return idProgresso;
    }

    public void setIdProgresso(double idProgresso) {
        this.idProgresso = idProgresso;
    }

    public int getPercente() {
        return percente;
    }

    public void setPercente(int percente) {
        this.percente = percente;
    }

    public int getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(int dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setDataFim(int dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public int getXpGanho() {
        return xpGanho;
    }

    @Override
    public void setXpGanho(int xpGanho) {
        this.xpGanho = xpGanho;
    }
}
