package com.fala.ficr.controllers;

import com.fala.ficr.Dto.PacienteNaoVerbalDto;
import com.fala.ficr.model.usuario.PacienteNaoVerbal;
import com.fala.ficr.repositories.PacienteNaoVerbalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/paciente")
public class PacienteNaoVerbalController {

    @Autowired
    PacienteNaoVerbalRepository pacienteNaoVerbalRepository;


    @PostMapping
    public ResponseEntity<PacienteNaoVerbal> saveUsuarioNaoVerbal(@RequestBody @Valid PacienteNaoVerbalDto pacienteNaoVerbalDto) {
        var paciente = new PacienteNaoVerbal();
        BeanUtils.copyProperties(pacienteNaoVerbalDto, paciente);
        paciente.setNivel(1);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteNaoVerbalRepository.save(paciente));
    }

    @GetMapping
    public ResponseEntity<List<PacienteNaoVerbal>> getUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteNaoVerbalRepository.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneUsuarioNaoVerbal(@PathVariable(value = "id") UUID id){
        Optional<PacienteNaoVerbal> usuarioNaoVerbalOp = pacienteNaoVerbalRepository.findById(id);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioNaoVerbalOp.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> upUsuarioNaoVerbal(@PathVariable(value = "id") UUID id,
                                          @RequestBody @Valid PacienteNaoVerbalDto pacienteNaoVerbalDto){
        Optional<PacienteNaoVerbal> usuarioNaoVerbalOp = pacienteNaoVerbalRepository.findById(id);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        var medicoAdm = usuarioNaoVerbalOp.get();
        BeanUtils.copyProperties(pacienteNaoVerbalDto, medicoAdm);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteNaoVerbalRepository.save(medicoAdm));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUsuarioNaoVerbal(@PathVariable(value = "id") UUID id){
        Optional<PacienteNaoVerbal> usuarioNaoVerbalOp = pacienteNaoVerbalRepository.findById(id);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        pacienteNaoVerbalRepository.delete(usuarioNaoVerbalOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
