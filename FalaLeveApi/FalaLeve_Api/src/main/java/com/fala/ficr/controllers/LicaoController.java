package com.fala.ficr.controllers;

import com.fala.ficr.Dto.LicaoDto;
import com.fala.ficr.model.licao.Licao;
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
@RequestMapping("/licao")
public class LicaoController {

    @Autowired
    LicaoRepository licaoRepository;

    @PostMapping
    public ResponseEntity<Licao> saveLicao(@RequestBody @Valid LicaoDto licaoDto){
        var licao = new Licao();
        BeanUtils.copyProperties(licaoDto, licao);
        return ResponseEntity.status(HttpStatus.CREATED).body(licaoRepository.save(licao));
    }


    @GetMapping
    public ResponseEntity<List<Licao>> getLicao(){
        return ResponseEntity.status(HttpStatus.OK).body(licaoRepository.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneLicao(@PathVariable(value = "id") UUID id){
        Optional<Licao> licaooOp = licaoRepository.findById(id);
        if(licaooOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lição não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(licaooOp.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>upLicao(@PathVariable(value = "id") UUID id,
                                          @RequestBody @Valid LicaoDto licaoDto){

        Optional<Licao> licaoOp = licaoRepository.findById(id);
        if(licaoOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lição não encontrado");
        }
        var licao = licaoOp.get();
        BeanUtils.copyProperties(licaoDto, licao);
        return ResponseEntity.status(HttpStatus.OK).body(licaoRepository.save(licao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLicao(@PathVariable(value = "id") UUID id){
        Optional<Licao> licaoOp = licaoRepository.findById(id);
        if(licaoOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Licao não encontrado");
        }
        licaoRepository.delete(licaoOp.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
