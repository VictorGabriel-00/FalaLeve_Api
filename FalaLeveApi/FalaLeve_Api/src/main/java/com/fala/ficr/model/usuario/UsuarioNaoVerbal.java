package com.fala.ficr.model.usuario;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO_NAO_VERBAL")
public class UsuarioNaoVerbal extends Usuario {
    private int grau;
    private int fonteTamanho;
    private String cor;
    private String animacao;
    private String son;


    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getFonteTamanho() {
        return fonteTamanho;
    }

    public void setFonteTamanho(int fonteTamanho) {
        this.fonteTamanho = fonteTamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAnimacao() {
        return animacao;
    }

    public void setAnimacao(String animacao) {
        this.animacao = animacao;
    }


}
