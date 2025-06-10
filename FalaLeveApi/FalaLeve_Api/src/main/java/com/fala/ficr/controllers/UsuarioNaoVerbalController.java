package com.fala.ficr.controllers;

import com.fala.ficr.Dto.UsuarioNaoVerbalDto;
import com.fala.ficr.model.usuario.UsuarioNaoVerbal;
import com.fala.ficr.repositories.UsuarioNaoVerbalRepository;
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
public class UsuarioNaoVerbalController {

    @Autowired
    UsuarioNaoVerbalRepository usuarioNaoVerbalRepository;


    @PostMapping("/usuarioNaoVerbal")
    public ResponseEntity<UsuarioNaoVerbal> saveUsuarioNaoVerbal(@RequestBody @Valid UsuarioNaoVerbalDto usuarioNaoVerbalDto) {
        var usuarioNaoVerbalAdm = new UsuarioNaoVerbal();
        BeanUtils.copyProperties(usuarioNaoVerbalDto, usuarioNaoVerbalAdm);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNaoVerbalRepository.save(usuarioNaoVerbalAdm));
    }

    @GetMapping("/usuarioNaoVerbal")
    public ResponseEntity<List<UsuarioNaoVerbal>> getUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioNaoVerbalRepository.findAll());
    }

    @GetMapping ("/usuarioNaoVerbal/{id}")
    public ResponseEntity<Object> getOneUsuarioNaoVerbal(@PathVariable(value = "id") UUID id){
        Optional<UsuarioNaoVerbal> usuarioNaoVerbalOp = usuarioNaoVerbalRepository.findById(id);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioNaoVerbalOp.get());
    }

    @PutMapping("/usuarioNaoVerbal/{id}")
    public ResponseEntity<Object> upUsuarioNaoVerbal(@PathVariable(value = "id") UUID id,
                                          @RequestBody @Valid UsuarioNaoVerbalDto usuarioNaoVerbalDto){
        Optional<UsuarioNaoVerbal> usuarioNaoVerbalOp = usuarioNaoVerbalRepository.findById(id);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        var medicoAdm = usuarioNaoVerbalOp.get();
        BeanUtils.copyProperties(usuarioNaoVerbalDto, medicoAdm);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioNaoVerbalRepository.save(medicoAdm));
    }

    @DeleteMapping("/usuarioNaoVerbal/{id}")
    public ResponseEntity<Object> deleteUsuarioNaoVerbal(@PathVariable(value = "id") UUID id){
        Optional<UsuarioNaoVerbal> usuarioNaoVerbalOp = usuarioNaoVerbalRepository.findById(id);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        usuarioNaoVerbalRepository.delete(usuarioNaoVerbalOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
