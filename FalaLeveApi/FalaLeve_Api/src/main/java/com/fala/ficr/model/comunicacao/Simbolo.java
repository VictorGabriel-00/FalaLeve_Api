package com.fala.ficr.model.comunicacao;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_SIMBOLO")
public class Simbolo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSimbolo;
    @Column(length = 200, nullable = false)
    private String descricaoSimbolo;
    @Column(length = 200, nullable = false)
    private String categoriaSimbolo;
    @Column(length = 200, nullable = false)
    private String URLImagemSimbolo;
    @Column(length = 200, nullable = false)
    private String URLaudioSimbolo;
    @Column(length = 200, nullable = false)
    private String tagsSimbolo;

    public UUID getIdSimbolo() {
        return idSimbolo;
    }

    public void setIdSimbolo(UUID idSimbolo) {
        this.idSimbolo = idSimbolo;
    }

    public String getDescricaoSimbolo() {
        return descricaoSimbolo;
    }

    public void setDescricaoSimbolo(String descricaoSimbolo) {
        this.descricaoSimbolo = descricaoSimbolo;
    }

    public String getCategoriaSimbolo() {
        return categoriaSimbolo;
    }

    public void setCategoriaSimbolo(String categoriaSimbolo) {
        this.categoriaSimbolo = categoriaSimbolo;
    }

    public String getURLImagemSimbolo() {
        return URLImagemSimbolo;
    }

    public void setURLImagemSimbolo(String URLImagemSimbolo) {
        this.URLImagemSimbolo = URLImagemSimbolo;
    }

    public String getURLaudioSimbolo() {
        return URLaudioSimbolo;
    }

    public void setURLaudioSimbolo(String URLaudioSimbolo) {
        this.URLaudioSimbolo = URLaudioSimbolo;
    }

    public String getTagsSimbolo() {
        return tagsSimbolo;
    }

    public void setTagsSimbolo(String tagsSimbolo) {
        this.tagsSimbolo = tagsSimbolo;
    }
}
