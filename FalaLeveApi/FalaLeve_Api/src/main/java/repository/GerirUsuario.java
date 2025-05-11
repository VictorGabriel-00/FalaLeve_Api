package repository;

public interface GerirUsuario {
    void addusuario(String nome, String email, String senha, int dataAnicersario);
    void removerusuario(String email, String senha);
    void editusuario(String email, String senha);
    void listarusuario(String email, String senha);
}
