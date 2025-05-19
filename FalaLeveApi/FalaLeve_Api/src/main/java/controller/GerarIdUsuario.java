package controller;


import model.IdUsuario;
import repository.RepositorioIdUsuario;


public class GerarIdUsuario {
    RepositorioIdUsuario repositorioIdUsuario = new RepositorioIdUsuario();
    IdUsuario idUsuario = new IdUsuario();


    public static String idAleatorio(){
        String idAleatorio = String.valueOf(System.currentTimeMillis()).substring(6);
        return idAleatorio;
    }

    public String GerenciarIdUsuario(String tipoId){
        String id,idN ;
       idUsuario.setTipoId(tipoId);

            id = idAleatorio();
            if(idUsuario.getTipoId().equalsIgnoreCase("medico")){
                idN = "MED";
                idUsuario.setId(idN + "-" + id);
                repositorioIdUsuario.AddIdUsuario(idUsuario);
            } else if (idUsuario.getTipoId().equalsIgnoreCase("Parente Responsavel")){
                idN = "RES";
                idUsuario.setId(idN + "-" + id);
                repositorioIdUsuario.AddIdUsuario(idUsuario);
            }else{
                idN = "PAC";
                idUsuario.setId(idN + "-" + id);
                repositorioIdUsuario.AddIdUsuario(idUsuario);
            }
        return idUsuario.getId();
    }

}
