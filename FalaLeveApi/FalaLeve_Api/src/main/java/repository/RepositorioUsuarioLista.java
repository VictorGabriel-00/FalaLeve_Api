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
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getEmail().equals(email)) {
                listaUsuarios.remove(i);
                i--;
            }
        }
    }

    public boolean removerUsuarioPorEmail(String email) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                listaUsuarios.remove(usuario);
                return true;
            }
        }
        return false;
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
