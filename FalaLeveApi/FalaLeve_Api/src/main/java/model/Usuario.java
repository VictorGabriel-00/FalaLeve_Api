package model;

public class Usuario {
    public String nome;
    private String email;
    private String senha;
    public int DataAniversario;
    public String op;


    public Usuario(String nome, String email, String senha, int DataAniversario) {
        this.nome = nome;
        this.setEmail(email);
        this.setSenha(senha);
        this.DataAniversario = DataAniversario;
    }

    public Usuario(){}

    public Usuario(String email){
        this.setEmail(email);
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String verificarSenha(String op){
        int senhaInt;
        senhaInt = Integer.parseInt(this.senha);
        if (senhaInt < 5){
            System.out.println("Senha Muito fraca,crie outra senha");
            this.op = "Tente novamente";
        }

        return this.senha;
    }

}
