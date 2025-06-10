package com.fala.ficr.controllers;

import com.fala.ficr.model.Medico;
import com.fala.ficr.recordDto.MedicoRecordDto;
import com.fala.ficr.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/medicos")
    public ResponseEntity<Medico> saveMedico(@RequestBody @Valid MedicoRecordDto medicoRecordDto){
        var newMedico = new Medico();
        BeanUtils.copyProperties(medicoRecordDto, newMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(newMedico));
    }

}
