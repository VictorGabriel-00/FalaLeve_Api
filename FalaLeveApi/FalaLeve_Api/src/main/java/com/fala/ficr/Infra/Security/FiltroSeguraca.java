package com.fala.ficr.Infra.Security;


import com.fala.ficr.Repositories.MedicoRepository;
import com.fala.ficr.Repositories.PacienteNaoVerbalRepository;
import com.fala.ficr.Services.TokenServices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class FiltroSeguraca extends OncePerRequestFilter {

    @Autowired
    TokenServices tokenServices;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteNaoVerbalRepository pacienteNaoVerbalRepository;

    private String recuperarToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) {
            return null;
        };
        return authHeader.replace("Bearer ", "");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recuperarToken(request);

        if(token != null){
            var email = tokenServices.validarToken(token);

            if(!email.isEmpty()){
                var authentication = new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }


}





