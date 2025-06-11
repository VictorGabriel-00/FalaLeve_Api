package com.fala.ficr.controllers;

import com.fala.ficr.Dto.CuidadorResponsavelDto;
import com.fala.ficr.Dto.ExercicioDto;
import com.fala.ficr.model.licao.Exercicio;
import com.fala.ficr.repositories.ExercicioRepository;
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
public class ExercicioController {

    @Autowired
    ExercicioRepository exercicioRepository;

    @PostMapping("/exercicio")
    public ResponseEntity<Exercicio> saveExercicio(@RequestBody @Valid ExercicioDto exercicioDto){
        var exercicioadm = new Exercicio();
        BeanUtils.copyProperties(exercicioDto, exercicioadm);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioRepository.save(exercicioadm));
    }


    @GetMapping("/exercicio")
    public ResponseEntity<List<Exercicio>> getExercicio(){
        return ResponseEntity.status(HttpStatus.OK).body(exercicioRepository.findAll());
    }

    @GetMapping ("/exercicio/{id}")
    public ResponseEntity<Object> getOneExercicio(@PathVariable(value = "id") UUID id){
        Optional<Exercicio> exercicioOp = exercicioRepository.findById(id);
        if(exercicioOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(exercicioOp.get());
    }


    @PutMapping("/exercicio/{id}")
    public ResponseEntity<Object>upExercicio(@PathVariable(value = "id") UUID id,
                                          @RequestBody @Valid ExercicioDto exercicioDto){
        Optional<Exercicio> exercicioOp = exercicioRepository.findById(id);
        if(exercicioOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio não encontrado");
        }
        var exercicioAdm = exercicioOp.get();
        BeanUtils.copyProperties(exercicioDto, exercicioAdm);
        return ResponseEntity.status(HttpStatus.OK).body(exercicioRepository.save(exercicioAdm));
    }

    @DeleteMapping("/exercicio/{id}")
    public ResponseEntity<Object> deleteExercicio(@PathVariable(value = "id") UUID id){
        Optional<Exercicio> exercicioOp = exercicioRepository.findById(id);
        if(exercicioOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio não encontrado");
        }
        exercicioRepository.delete(exercicioOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
