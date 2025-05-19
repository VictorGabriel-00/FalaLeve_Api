package repository;

import interfaces.GeririIdUsuario;
import model.IdUsuario;
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
    public void RemoverIdUsuario(IdUsuario idUsuario) {
    }
    public List<IdUsuario> listaIdUsuario() {
        return this.listaIdUsuario;
    }

}
