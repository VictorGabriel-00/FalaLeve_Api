package controller;


import model.IdUsuario;
import repository.RepositorioIdUsuario;


public class GerarIdUsuario {
    IdUsuario idUsuario = new IdUsuario();

    public String idFixo;

    public static String idAleatorio(){
        String idAleatorio = String.valueOf(System.currentTimeMillis()).substring(6);
        return idAleatorio;
    }

    public String GerenciarIdUsuario(String tipoId, RepositorioIdUsuario listaIdUsuario){
        String id,idN;
       idUsuario.setTipoId(tipoId);

            id = idAleatorio();
            if(idUsuario.getTipoId().equalsIgnoreCase("medico")){
                idN = "MED";
                idUsuario.setId(idN + "-" + id);
                idFixo = idUsuario.getId();
                listaIdUsuario.AddIdUsuario(idUsuario);
            } else if (idUsuario.getTipoId().equalsIgnoreCase("Parente Responsavel")){
                idN = "RES";
                idUsuario.setId(idN + "-" + id);
                idFixo = idUsuario.getId();
                listaIdUsuario.AddIdUsuario(idUsuario);
            }else{
                idN = "PAC";
                idUsuario.setId(idN + "-" + id);
                idFixo = idUsuario.getId();
                listaIdUsuario.AddIdUsuario(idUsuario);
            }
        return idFixo;
    }

}
