package controller;

import java.util.UUID;


public class GerarIdMedico {

    public static String idAleatorio(String prefixo, int num){

        String idAleatorio = String.valueOf(System.currentTimeMillis()).substring(6);

        return prefixo + idAleatorio + num;

    }

    public GerarIdMedico(){}

}
