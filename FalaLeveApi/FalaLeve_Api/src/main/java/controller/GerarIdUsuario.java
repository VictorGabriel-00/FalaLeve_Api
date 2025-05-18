package controller;


public class GerarIdUsuario {

    private static String idFixo;

    public static String opID;



    public static String idAleatorio(){

        String idAleatorio = String.valueOf(System.currentTimeMillis()).substring(6);

        return idAleatorio;
    }

    public String GerenciarIdUsuario(String tipoId){
        String id,idN ;
        if (idFixo == null) {
            id = idAleatorio();
            if(opID.equalsIgnoreCase("medico")){
                idN = "MED";
                idFixo = idN + "-" + id;
            } else if (opID.equalsIgnoreCase("Parente Responsavel")){
                idN = "RES";
                idFixo = idN + "-" + id;
            }else{
                idN = "PAC";
                idFixo = idN + "-" + id;
            }

        }
        return idFixo;
    }

}
