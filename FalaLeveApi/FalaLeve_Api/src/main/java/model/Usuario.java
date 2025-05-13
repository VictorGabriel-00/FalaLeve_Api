package model;

public class Usuario {
    private String idUsuario;
    private String nome;
    private String email;
    private String senha;
    private int DataAniversario;
    public String op;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataAniversario() {
        return DataAniversario;
    }

    public void setDataAniversario(int dataAniversario) {
        DataAniversario = dataAniversario;
    }

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

    @Override
    public String toString(){
        return "[Nome: " + getNome() + " - Email: " + getEmail() + " - Data de Aniversario: "
                + getDataAniversario() + "]";
    }

}
