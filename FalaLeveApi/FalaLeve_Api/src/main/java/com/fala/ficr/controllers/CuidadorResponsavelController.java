package com.fala.ficr.controllers;

import com.fala.ficr.Dto.CuidadorResponsavelDto;
import com.fala.ficr.model.usuario.CuidadorResponsavel;
import com.fala.ficr.repositories.CuidadorResponsavelRepository;
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
public class CuidadorResponsavelController{
    @Autowired
    CuidadorResponsavelRepository cuidadorResponsavelRepository;

    @PostMapping("/cuidador")
    public ResponseEntity<CuidadorResponsavel> saveCuidadorResponsavel(@RequestBody @Valid CuidadorResponsavelDto cuidadorResponsavelDto){
        var cuidadorAdm = new CuidadorResponsavel();
        BeanUtils.copyProperties(cuidadorResponsavelDto, cuidadorAdm);
        return ResponseEntity.status(HttpStatus.CREATED).body(cuidadorResponsavelRepository.save(cuidadorAdm));
    }


    @GetMapping("/cuidador")
    public ResponseEntity<List<CuidadorResponsavel>> getCuidadorResponsavel(){
        return ResponseEntity.status(HttpStatus.OK).body(cuidadorResponsavelRepository.findAll());
    }

    @GetMapping ("/cuidador/{id}")
    public ResponseEntity<Object> getOneCuidador(@PathVariable(value = "id") UUID id){
        Optional<CuidadorResponsavel> cuidadorOp = cuidadorResponsavelRepository.findById(id);
        if(cuidadorOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuidador não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cuidadorOp.get());
    }


    @PutMapping("/cuidador/{id}")
    public ResponseEntity<Object>upMedico(@PathVariable(value = "id") UUID id,
                                          @RequestBody @Valid CuidadorResponsavelDto cuidadorResponsavelDto){

        Optional<CuidadorResponsavel> cuidadorOp = cuidadorResponsavelRepository.findById(id);
        if(cuidadorOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuidador não encontrado");
        }
        var cuidadorAdm = cuidadorOp.get();
        BeanUtils.copyProperties(cuidadorResponsavelDto, cuidadorAdm);
        return ResponseEntity.status(HttpStatus.OK).body(cuidadorResponsavelRepository.save(cuidadorAdm));
    }

    @DeleteMapping("/cuidador/{id}")
    public ResponseEntity<Object> deleteMedico(@PathVariable(value = "id") UUID id){
        Optional<CuidadorResponsavel> cuidadorOp = cuidadorResponsavelRepository.findById(id);
        if(cuidadorOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuidador não encontrado");
        }
        cuidadorResponsavelRepository.delete(cuidadorOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
