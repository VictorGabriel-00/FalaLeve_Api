package com.fala.ficr.model.comunicacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SIMBOLO")
public class Simbolo {
    @Id
    @Column(length = 50, nullable = false, unique = true)
    private int idSimbolo;
    @Column(length = 200, nullable = false)
    private String descricaoSimbolo;
    @Column(length = 200, nullable = false)
    private String categoriaSimbolo;
    @Column(length = 200, nullable = false, unique = true)
    private String URLImagemSimbolo;
    @Column(length = 200, nullable = false, unique = true)
    private String URLaudioSimbolo;
    @Column(length = 200, nullable = false)
    private String tagsSimbolo;

    public int getIdSimbolo() {
        return idSimbolo;
    }

    public void setIdSimbolo(int idSimbolo) {
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
