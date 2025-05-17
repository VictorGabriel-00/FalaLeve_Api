package interfaces;

import model.Usuario;
import model.UsuarioNaoVerbal;

import java.util.List;

public interface GerirUsuario {
    void addusuario(Usuario usuario);
    void removerusuario(String email);
    Usuario editusuario(String email);
    Usuario procurarUsuario(String email);
    List<Usuario> listarUsuarios();
}
