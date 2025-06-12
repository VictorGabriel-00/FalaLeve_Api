package com.fala.ficr.controllers;

import com.fala.ficr.Dto.PacienteNaoVerbalDto;
import com.fala.ficr.Dto.SimboloDTO;
import com.fala.ficr.model.comunicacao.Simbolo;
import com.fala.ficr.model.usuario.PacienteNaoVerbal;
import com.fala.ficr.repositories.SimboloRepository;
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
@RequestMapping("/simbolo")
public class SimboloController {

    @Autowired
    SimboloRepository simboloRepository;

    @PostMapping
    public ResponseEntity<Simbolo> saveSimbolo(@RequestBody @Valid SimboloDTO simboloDto) {
        var simbolo = new Simbolo();
        BeanUtils.copyProperties(simboloDto, simbolo);
        return ResponseEntity.status(HttpStatus.CREATED).body(simboloRepository.save(simbolo));
    }

    @GetMapping
    public ResponseEntity<List<Simbolo>> getSimbolo(){
        return ResponseEntity.status(HttpStatus.OK).body(simboloRepository.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneSimbolo(@PathVariable(value = "id") UUID id){
        Optional<Simbolo> simboloOp = simboloRepository.findById(id);
        if(simboloOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Simbolo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(simboloOp.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> upSimbolo(@PathVariable(value = "id") UUID id,
                                                     @RequestBody @Valid SimboloDTO simboloDTO){
        Optional<Simbolo> simboloOp = simboloRepository.findById(id);
        if(simboloOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Simbolo não encontrado");
        }
        var simbolo = simboloOp.get();
        BeanUtils.copyProperties(simboloDTO, simbolo);
        return ResponseEntity.status(HttpStatus.OK).body(simboloRepository.save(simbolo));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteSimbolo(@PathVariable(value = "id") UUID id){
        Optional<Simbolo> simboloOp = simboloRepository.findById(id);
        if(simboloOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Simbolo não encontrado");
        }
        simboloRepository.delete(simboloOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
