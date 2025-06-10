package com.fala.ficr.model.usuario;

public class IdUsuario {
    private String id;
    private String tipoId;
    private String idFixo;
    private String IdProntuario;

    public String getIdProntuario() {
        return IdProntuario;
    }

    public void setIdProntuario(String idProntuario) {
        IdProntuario = idProntuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getIdFixo() {
        return idFixo;
    }

    public void setIdFixo(String idFixo) {
        this.idFixo = idFixo;
    }



    @Override
    public String toString(){
            return  "Id: " + getId();
    }


}
