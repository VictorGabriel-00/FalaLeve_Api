package com.fala.ficr.model.usuario;


import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    private LocalDateTime dataAcesso;
    @Column(nullable = false, length = 50)
    private LocalDateTime ultimoAcesso;
    @Column(length = 50)
    private String statusAtivo;


    @PrePersist
    protected void onCreate() {
        this.dataAcesso = LocalDateTime.now();
        this.ultimoAcesso = LocalDateTime.now();
        this.statusAtivo = "ATIVO";
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
