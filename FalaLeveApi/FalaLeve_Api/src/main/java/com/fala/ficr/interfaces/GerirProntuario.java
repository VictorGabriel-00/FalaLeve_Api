package com.fala.ficr.interfaces;

import com.fala.ficr.model.UsuarioNaoVerbal;
import java.util.List;

public interface GerirProntuario {
    void addProntuario(UsuarioNaoVerbal prontuario);
    void removerProntuario(String email);
    UsuarioNaoVerbal editProntuario(UsuarioNaoVerbal prontuario);
    UsuarioNaoVerbal listarProntuario(String email);
    List<UsuarioNaoVerbal> prontuarioUsuario();
}
