package model;

public abstract class Usuario {
    public String nome;
    private String email;
    private String senha;
    public int DataAniversario;

    public abstract String escolha(String ump);

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
}
