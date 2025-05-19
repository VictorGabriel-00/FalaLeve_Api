package model;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String DataAniversario;
    public String opSenha;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAniversario() {
        return DataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        DataAniversario = dataAniversario;
    }

    public Usuario(){}


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
            this.opSenha = "Tente novamente";
        }else{
            System.out.println("Senha criada com sucesso");
            this.opSenha = "Senha criada com sucesso";
        }

        return senha;
    }

    public void dataNascimento(int data){
        String contagem = String.valueOf(data);
        String primeiro = contagem.substring(0,2);
        String segundo = contagem.substring(2,4);
        String terceiro = contagem.substring(4, 8);
        DataAniversario = primeiro + "/" + segundo  + "/" + terceiro;
    }


    @Override
    public String toString(){
        return  "Nome: " + getNome() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Data de Aniversario: " + getDataAniversario() + "\n";
    }

}
