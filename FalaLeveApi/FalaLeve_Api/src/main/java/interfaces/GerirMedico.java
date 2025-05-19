package interfaces;

import model.Medico;

import java.util.List;

public interface GerirMedico {
    void addMedico(Medico medico);
    void removerMedico(String email);
    Medico editMedico(String email);
    Medico listarMedico(String email);
    List<Medico> listarMedicos();
}
