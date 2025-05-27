package com.fala.ficr.interfaces;

import com.fala.ficr.model.ParenteResponsavel;

import java.util.List;

public interface GerirParenteResponsavel {
    void addParenteResponsavel(ParenteResponsavel parenteResponsavel);
    void removerParenteResponsavel(String email);
    ParenteResponsavel editParenteResponsavel(String email);
    ParenteResponsavel listarParenteResponsavel(String email);
    List<ParenteResponsavel> listarParenteResponsavel();
}
