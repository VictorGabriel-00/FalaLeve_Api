package com.fala.ficr.repository;

import com.fala.ficr.interfaces.GerirUsuario;
import com.fala.ficr.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarioLista implements GerirUsuario {

    private List<Usuario> listaUsuarios;

    public RepositorioUsuarioLista() {listaUsuarios = new ArrayList<Usuario>();}

    @Override
    public void addusuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    @Override
    public void removerusuario(String email) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getEmail().equals(email)) {
                listaUsuarios.remove(i);
                i--;
            }
        }
    }

    @Override
    public Usuario editusuario(String email) {
        return null;
    }

    @Override
    public Usuario procurarUsuario(String email) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return this.listaUsuarios;
    }

}
