package com.fala.ficr.interfaces;

import com.fala.ficr.model.Usuario;

import java.util.List;

public interface GerirUsuario {
    void addusuario(Usuario usuario);
    void removerusuario(String email);
    Usuario editusuario(String email);
    Usuario procurarUsuario(String email);
    List<Usuario> listarUsuarios();
}
