package com.fala.ficr.repository;

import com.fala.ficr.interfaces.GerirMedico;
import com.fala.ficr.model.Medico;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMedico implements GerirMedico {

    private List<Medico> listaMedico;

    public RepositorioMedico() {this.listaMedico = new ArrayList<Medico>();}

    @Override
    public void addMedico(Medico medico) {
        listaMedico.add(medico);
    }

    @Override
    public void removerMedico(String crm) {
        for (int i = 0; i < listaMedico.size(); i++) {
            if (listaMedico.get(i).getCrm().equals(crm)) {
                listaMedico.remove(i);
                i--;
            }
        }
    }

    @Override
    public Medico editMedico(String email) {
        return null;
    }

    @Override
    public Medico listarMedico(String email) {
        return null;
    }

    @Override
    public List<Medico> listarMedicos() {
        return this.listaMedico;
    }
}
