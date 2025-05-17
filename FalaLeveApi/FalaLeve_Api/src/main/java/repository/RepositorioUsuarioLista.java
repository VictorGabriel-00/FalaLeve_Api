package repository;

import interfaces.GerirUsuario;
import model.Usuario;
import model.UsuarioNaoVerbal;

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
