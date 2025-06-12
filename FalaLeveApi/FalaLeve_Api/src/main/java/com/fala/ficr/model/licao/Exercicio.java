package com.fala.ficr.model.licao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "TB_EXERCICIO")
public class Exercicio{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idExercicio;
    @Column(nullable = false, length = 50)
    private String nomeExercicio;
    @Column(nullable = false, length = 50)
    private String descricaoExercicio;
    @Column(nullable = false, length = 50)
    private String tipoExercicio;
    @Column(nullable = false, length = 50)
    private String instrucaoExercicio;
    @Column(nullable = false, length = 50)
    private int tempoExercicio;

    @ManyToOne
    @JoinColumn(name = "licao_id")
    @JsonIgnore
    private Licao licao;

    public Licao getLicao() {
        return licao;
    }

    public void setLicao(Licao licao) {
        this.licao = licao;
    }

    public UUID getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(UUID idExercicio) {
        this.idExercicio = idExercicio;
    }

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
