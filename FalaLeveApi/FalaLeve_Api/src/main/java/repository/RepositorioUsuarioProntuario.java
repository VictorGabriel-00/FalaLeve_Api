package repository;


import interfaces.GerirProntuario;
import model.UsuarioNaoVerbal;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarioProntuario implements GerirProntuario {
    private List<UsuarioNaoVerbal> prontuarios;

    public RepositorioUsuarioProntuario() {
        prontuarios = new ArrayList<UsuarioNaoVerbal>();
    }

    @Override
    public void addProntuario(UsuarioNaoVerbal prontuario) {
        prontuarios.add(prontuario);
    }

    @Override
    public void removerProntuario(String email) {

    }

    @Override
    public UsuarioNaoVerbal editProntuario(String email) {
        return null;
    }

    @Override
    public UsuarioNaoVerbal listarProntuario(String email) {
        return null;
    }

    @Override
    public List<UsuarioNaoVerbal> prontuarioUsuario() {
        return this.prontuarios;
    }
}