package repository;

import interfaces.GerirParenteResponsavel;
import model.ParenteResponsavel;
import java.util.ArrayList;
import java.util.List;

public class RepositorioParenteResponsavel implements GerirParenteResponsavel {

    private List<ParenteResponsavel> listaParenteResponsavel;

    public RepositorioParenteResponsavel() {
        this.listaParenteResponsavel = new ArrayList<ParenteResponsavel>();
    }

    @Override
    public void addParenteResponsavel(ParenteResponsavel parenteResponsavel) {
        listaParenteResponsavel.add(parenteResponsavel);

    }

    @Override
    public void removerParenteResponsavel(String email) {
        for (int i = 0; i < listaParenteResponsavel.size(); i++) {
            if (listaParenteResponsavel.get(i).getEmailParente().equals(email)) {
                listaParenteResponsavel.remove(i);
                i--;
            }
        }
    }

    @Override
    public ParenteResponsavel editParenteResponsavel(String email) {
        return null;
    }

    @Override
    public ParenteResponsavel listarParenteResponsavel(String email) {
        return null;
    }

    @Override
    public List<ParenteResponsavel> listarParenteResponsavel() {
        return this.listaParenteResponsavel;
    }
}
