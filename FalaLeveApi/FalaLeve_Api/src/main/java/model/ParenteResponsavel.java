package model;

import view.MenuPrincipal;

public class ParenteResponsavel extends Usuario{

    private String emailParente;
    private String senhaParente;
    private String nomeParente;
    private String dataAniversarioParente;
    public String opSenhaParente;

    public String getEmailParente() {
        return emailParente;
    }

    public void setEmailParente(String emailParente) {
        this.emailParente = emailParente;
    }

    public String getSenhaParente() {
        return senhaParente;
    }

    public void setSenhaParente(String senhaParente) {
        this.senhaParente = senhaParente;
    }

    public String getNomeParente() {
        return nomeParente;
    }

    public void setNomeParente(String nomeParente) {
        this.nomeParente = nomeParente;
    }

    public String getDataAniversarioParente() {
        return dataAniversarioParente;
    }

    public void setDataAniversarioParente(String dataAniversarioParente) {
        this.dataAniversarioParente = dataAniversarioParente;
    }

    @Override
    public String verificarSenha(String op){
        int senhaInt;
        senhaInt = String.valueOf(senhaParente).length();
        if (senhaInt < 5){
            System.out.println("Senha Muito fraca,crie outra senha");
            this.opSenhaParente = "Tente novamente";
        }else{
            System.out.println("Senha criada com sucesso");
            this.opSenhaParente = "Senha criada com sucesso";
        }

        return senhaParente;
    }

    public void dataNascimento(int data){
        String contagem = String.valueOf(data);
        String primeiro = contagem.substring(0,2);
        String segundo = contagem.substring(2,4);
        String terceiro = contagem.substring(4, 8);
        dataAniversarioParente = primeiro + "/" + segundo  + "/" + terceiro;
    }

    @Override
    public String toString(){
        return "Nome do Parente: " + getNomeParente() + "\n" +
                "Email do Parente: " + getEmailParente() + "\n" +
                "Senha do Parente: " + getSenhaParente() + "\n" +
                "Data de Aniversario do Parente: " + getDataAniversarioParente() + "\n";
    }

}
