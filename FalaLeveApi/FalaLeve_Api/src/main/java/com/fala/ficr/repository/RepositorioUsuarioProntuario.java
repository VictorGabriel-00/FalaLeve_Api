package com.fala.ficr.repository;


import com.fala.ficr.interfaces.GerirProntuario;
import com.fala.ficr.model.UsuarioNaoVerbal;

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
    public void removerProntuario(String idp) {
        for (int i = 0; i < prontuarios.size(); i++) {
            if (prontuarios.get(i).getIdProntuario().equals(idp)) {
                prontuarios.remove(i);
                i--;
            }
        }

    }

    @Override
    public  UsuarioNaoVerbal editProntuario(UsuarioNaoVerbal prontuario) {
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