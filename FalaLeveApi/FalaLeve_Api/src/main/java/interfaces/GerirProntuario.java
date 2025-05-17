package interfaces;

import model.UsuarioNaoVerbal;
import java.util.List;

public interface GerirProntuario {
    void addProntuario(UsuarioNaoVerbal prontuario);
    void removerProntuario(String email);
    UsuarioNaoVerbal editProntuario(String email);
    UsuarioNaoVerbal listarProntuario(String email);
    List<UsuarioNaoVerbal> prontuarioUsuario();
}
