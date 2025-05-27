package com.fala.ficr.repository;

import com.fala.ficr.interfaces.GeririIdUsuario;
import com.fala.ficr.model.IdUsuario;
import java.util.List;

public class RepositorioIdUsuario implements GeririIdUsuario {
    private List<IdUsuario> listaIdUsuario;

    public RepositorioIdUsuario() {
        listaIdUsuario = new java.util.ArrayList<IdUsuario>();
    }

    @Override
    public void AddIdUsuario(IdUsuario idUsuario) {
        listaIdUsuario.add(idUsuario);
    }

    @Override
    public void RemoverIdUsuario(String idUsuario) {
        for (int i = 0; i < listaIdUsuario.size(); i++) {
            if (listaIdUsuario.get(i).getId().equals(idUsuario)) {
                listaIdUsuario.remove(i);
                i--;
            }
        }
    }
    public List<IdUsuario> listaIdUsuario() {
        return this.listaIdUsuario;
    }

}
