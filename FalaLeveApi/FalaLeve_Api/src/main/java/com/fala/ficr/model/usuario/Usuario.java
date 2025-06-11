package com.fala.ficr.model.usuario;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private UUID id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private String senha;
    @Column(nullable = false, length = 50)
    private String dataNascimento;
    @Column(length = 50)
    private String statusAtivo;
    @Column(length = 50)
    private String dataCriacaoConta;

    public void setStatusAtivo(String statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
