package com.fala.ficr.model.usuario;


import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private String senha;
    @Column(nullable = false, length = 50)
    private String dataAniversario;
    @Column(length = 50)
    private String statusAtivo;
    @Column(length = 50)
    private String dataCriacaoConta;

    public String getStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(String statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String opSenha;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
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
        dataAniversario = primeiro + "/" + segundo  + "/" + terceiro;
    }


    @Override
    public String toString(){
        return  "Nome: " + getNome() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Data de Aniversario: " + getDataAniversario() + "\n";
    }

}
