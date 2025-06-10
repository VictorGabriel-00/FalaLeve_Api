package com.fala.ficr.model.licao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Recompensa")
public class Recompensa extends Licao{
    private int idRecompensa;
    private int dataConcessao;
    private int dataResgate;
    private String statusRecompensa;
    private String descricaoRecompensa;
    private String tipoRecompensa;
    private int valorRecompensa;

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public int getDataConcessao() {
        return dataConcessao;
    }

    public void setDataConcessao(int dataConcessao) {
        this.dataConcessao = dataConcessao;
    }

    public int getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(int dataResgate) {
        this.dataResgate = dataResgate;
    }

    public String getStatusRecompensa() {
        return statusRecompensa;
    }

    public void setStatusRecompensa(String statusRecompensa) {
        this.statusRecompensa = statusRecompensa;
    }

    public String getDescricaoRecompensa() {
        return descricaoRecompensa;
    }

    public void setDescricaoRecompensa(String descricaoRecompensa) {
        this.descricaoRecompensa = descricaoRecompensa;
    }

    public String getTipoRecompensa() {
        return tipoRecompensa;
    }

    public void setTipoRecompensa(String tipoRecompensa) {
        this.tipoRecompensa = tipoRecompensa;
    }

    public int getValorRecompensa() {
        return valorRecompensa;
    }

    public void setValorRecompensa(int valorRecompensa) {
        this.valorRecompensa = valorRecompensa;
    }
}
