package model;

public class UsuarioNaoVerbal extends Usuario {
    private String prontuario;
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

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
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

    @Override
   public String toString() {
        return "Grau:" + getGrau() + "\n" +
                "Tamanho de Fonte: " + getFonteTamanho() + "\n" +
                "Cor Agradavel: " + getCor() + "\n" +
                "Preferencia de Animação: " + getAnimacao() + "\n" +
                "Preferencia de Som: " + getSon() + "\n";
    }


}
