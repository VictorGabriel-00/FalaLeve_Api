package controller;


public class GerarIdUsuario {

    public static String nome;
    private static String idFixo;


    public static String idAleatorio(){

        String idAleatorio = String.valueOf(System.currentTimeMillis()).substring(6);

        return idAleatorio;
    }

    public String GerenciarIdUsuario(){
        String id;
        if (idFixo == null) {
            id = idAleatorio();
            idFixo = nome +"-"+ id;
        }
        return idFixo;
    }

}
