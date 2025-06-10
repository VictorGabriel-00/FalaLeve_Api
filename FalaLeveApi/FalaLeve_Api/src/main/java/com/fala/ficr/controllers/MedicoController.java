package com.fala.ficr.controllers;

import com.fala.ficr.model.usuario.Medico;
import com.fala.ficr.Dto.MedicoRecordDto;
import com.fala.ficr.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
