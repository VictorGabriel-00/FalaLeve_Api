package com.fala.ficr.controllers;

import com.fala.ficr.model.usuario.Medico;
import com.fala.ficr.Dto.MedicoRecordDto;
import com.fala.ficr.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/medico")
    public ResponseEntity<Medico> saveMedico(@RequestBody @Valid MedicoRecordDto medicoRecordDto){
        var medicoAdm = new Medico();
        BeanUtils.copyProperties(medicoRecordDto, medicoAdm);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoAdm));
    }


    @GetMapping("/medico")
    public ResponseEntity<List<Medico>> getMedicos(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());
    }

    @GetMapping ("/medico/{id}")
    public ResponseEntity<Object> getOneMedico(@PathVariable(value = "id") UUID id){
        Optional<Medico> medicoOp = medicoRepository.findById(id);
        if(medicoOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicoOp.get());
    }


    @PutMapping("/medico/{id}")
    public ResponseEntity<Object>upMedico(@PathVariable(value = "id") UUID id,
                               @RequestBody @Valid MedicoRecordDto medicoRecordDto){

        Optional<Medico> medicoOp = medicoRepository.findById(id);

        if(medicoOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        var medicoAdm = medicoOp.get();
        BeanUtils.copyProperties(medicoRecordDto, medicoAdm);
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medicoAdm));
    }

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<Object> deleteMedico(@PathVariable(value = "id") UUID id){
        Optional<Medico> medicoOp = medicoRepository.findById(id);
        if(medicoOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        medicoRepository.delete(medicoOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
