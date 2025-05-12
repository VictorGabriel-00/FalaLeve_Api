package repository;

public interface GerirUsuario {
    void addusuario(String nome, String email, int senha, int dataAnicersario);
    void removerusuario(String email, int senha);
    void editusuario(String email, int senha);
    void listarusuario(String email, int senha);
}
