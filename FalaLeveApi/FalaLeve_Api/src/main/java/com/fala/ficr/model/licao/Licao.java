package com.fala.ficr.model.licao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_LICAO")
public class Licao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 200, unique = true,nullable = false)
    private String titulo;
    @Column(length = 500, nullable = false)
    private String descricao;
    @Column( nullable = false, length = 50)
    private int nivelDificuldade;
    @Column(length = 100, nullable = false)
    private int xpGanho;
    @Column(length = 50, nullable = false)
    private String categoria;
    @Column(length = 50, nullable = false)
    private int tempoEstimado;
    @Column(length = 50, nullable = false)
    private boolean disponibilidade;

    @OneToMany(mappedBy = "licao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercicio> exercicios;

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(int nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public int getXpGanho() {
        return xpGanho;
    }

    public void setXpGanho(int xpGanho) {
        this.xpGanho = xpGanho;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
