package model;

public class Usuario {
    public String nome;
    private String email;
    private int senha;
    public int DataAniversario;
    public String op;


    public Usuario(String nome, String email, int senha, int DataAniversario) {
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

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int verificarSenha(int op){
        int senhaInt;
        senhaInt = String.valueOf(senha).length();
        if (senhaInt < 5){
            System.out.println("Senha Muito fraca,crie outra senha");
            this.op = "Tente novamente";
        }else{
            System.out.println("Senha criada com sucesso");
            this.op = "Senha criada com sucesso";
        }

        return senha;
    }

}
