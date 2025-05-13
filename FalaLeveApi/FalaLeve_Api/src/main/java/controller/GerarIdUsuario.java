package controller;


import model.Usuario;

public class GerarIdUsuario {

    private static String idFixo;

    public static String op;



    public static String idAleatorio(){

        String idAleatorio = String.valueOf(System.currentTimeMillis()).substring(6);

        return idAleatorio;
    }

    public String GerenciarIdUsuario(){
        String id,idN ;
        if (idFixo == null) {
            id = idAleatorio();
            if(op.equalsIgnoreCase("Medico")){
                idN = "MED";
                idFixo = idN + "-" + id;
            } else if (op.equalsIgnoreCase("Parente Responsavel")){
                idN = "RES";
                idFixo = idN + "-" + id;
            }else{
                idN = "USN";
                idFixo = idN + "-" + id;
            }

        }
        return idFixo;
    }

}
