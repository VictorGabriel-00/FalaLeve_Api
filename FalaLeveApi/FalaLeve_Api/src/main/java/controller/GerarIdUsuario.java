package controller;


public class GerarIdUsuario {

    public static String nome;


    public static String idAleatorio(){

        String idAleatorio = String.valueOf(System.currentTimeMillis()).substring(6);

        idAleatorio = nome + "-" + idAleatorio;

        return idAleatorio;
    }

    public GerarIdUsuario(){}

}
