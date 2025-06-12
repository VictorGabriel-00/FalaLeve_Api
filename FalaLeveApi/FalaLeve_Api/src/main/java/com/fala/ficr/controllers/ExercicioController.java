package com.fala.ficr.controllers;

import com.fala.ficr.Dto.ExercicioDto;
import com.fala.ficr.model.licao.Exercicio;
import com.fala.ficr.model.licao.Licao;
import com.fala.ficr.repositories.ExercicioRepository;
import com.fala.ficr.repositories.LicaoRepository;
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
@RequestMapping("/exercicio")
public class ExercicioController {

    @Autowired
    ExercicioRepository exercicioRepository;
    @Autowired
    LicaoRepository licaoRepository;

    @PostMapping
    public ResponseEntity<Object> saveExercicio(@RequestBody @Valid ExercicioDto exercicioDto){
        UUID licaoId = exercicioDto.licao().getId();
        if (licaoId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ID da lição dentro do objeto 'licao' não pode ser nulo.");
        }
        Optional<Licao> licaoOp = licaoRepository.findById(licaoId);
        if (licaoOp.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lição não encontrada com o ID fornecido.");
        }
        var exercicio = new Exercicio();
        exercicio.setLicao(licaoOp.get());
        BeanUtils.copyProperties(exercicioDto, exercicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioRepository.save(exercicio));
    }


    @GetMapping
    public ResponseEntity<List<Exercicio>> getExercicio(){
        return ResponseEntity.status(HttpStatus.OK).body(exercicioRepository.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneExercicio(@PathVariable(value = "id") UUID id){
        Optional<Exercicio> exercicioOp = exercicioRepository.findById(id);
        if(exercicioOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(exercicioOp.get());
    }


    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExercicio(@PathVariable(value = "id") UUID id){
        Optional<Exercicio> exercicioOp = exercicioRepository.findById(id);
        if(exercicioOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exercicio não encontrado");
        }
        exercicioRepository.delete(exercicioOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
