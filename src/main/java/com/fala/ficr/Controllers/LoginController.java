package com.fala.ficr.Controllers;


import com.fala.ficr.Dto.LoginDTO;
import com.fala.ficr.Dto.LoginRespostaDTO;
import com.fala.ficr.Model.usuario.Medico;
import com.fala.ficr.Model.usuario.PacienteNaoVerbal;
import com.fala.ficr.Repositories.MedicoRepository;
import com.fala.ficr.Repositories.PacienteNaoVerbalRepository;
import com.fala.ficr.Services.TokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteNaoVerbalRepository pacienteNaoVerbalRepository;

    @Autowired
    private TokenServices tokenServices;


    @PostMapping("/login")
    public ResponseEntity<Object> realizarLogin(@RequestBody LoginDTO loginDTO){
        List<Medico> medicos = medicoRepository.findAll();
        for (Medico m : medicos) {
            if (m.getEmail().equals(loginDTO.email()) && m.getSenha().equals(loginDTO.senha())) {
                String token = tokenServices.gerarToken(m);
                return ResponseEntity.ok(new LoginRespostaDTO(m.getNome(), m.getId(), "MEDICO",token));
            }
        }

        List<PacienteNaoVerbal> paciente = pacienteNaoVerbalRepository.findAll();
        for(PacienteNaoVerbal p : paciente){
            if(p.getEmail().equals(loginDTO.email()) && p.getSenha().equals(loginDTO.senha())){
                String token = tokenServices.gerarToken(p);
                return ResponseEntity.ok(new LoginRespostaDTO(p.getNome(), p.getId(), "PACIENTE",token));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos!");

    }


}
