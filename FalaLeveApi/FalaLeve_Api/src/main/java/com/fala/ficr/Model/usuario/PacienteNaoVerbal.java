package com.fala.ficr.Model.usuario;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_PACIENTE_NAO_VERBAL")
@JsonPropertyOrder({ "id","medico", "nome", "email", "dataNascimento", "grau", "configuracao" })
public class PacienteNaoVerbal extends Usuario {

    private int grau;
    private String cores;
    private String sons;
    private int pontos ;
    private int nivel;
    private String configuracao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getSons() {
        return sons;
    }

    public void setSons(String sons) {
        this.sons = sons;
    }
}
