package com.fala.ficr.Controllers;

import com.fala.ficr.Model.usuario.Medico;
import com.fala.ficr.Dto.MedicoRecordDto;
import com.fala.ficr.Repositories.MedicoRepository;
import com.fala.ficr.Services.MedicoServices;
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
@RequestMapping("/medico")
@CrossOrigin(origins = "*")
public class MedicoController {
    @Autowired
    MedicoServices medicoServices;

    @PostMapping
    public ResponseEntity<Medico> saveMedico(@RequestBody @Valid MedicoRecordDto medicoRecordDto){
        Medico medico = medicoServices.criarMedico(medicoRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }


    @GetMapping
    public ResponseEntity<List<Medico>> getMedicos(){
        List<Medico> medicos = medicoServices.listarTodosMedicos();
        return ResponseEntity.status(HttpStatus.OK).body(medicos);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneMedico(@PathVariable(value = "id") UUID id){
        Optional<Medico> medicoOp = medicoServices.buscarPorId(id);
        if(medicoOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicoOp.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>upMedico(@PathVariable(value = "id") UUID id,
                               @RequestBody @Valid MedicoRecordDto medicoRecordDto){

        Optional<Medico> medicoOp = medicoServices.atualizarMedico(id, medicoRecordDto);

        if(medicoOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        var medicoAdm = medicoOp.get();
        BeanUtils.copyProperties(medicoRecordDto, medicoAdm);
        return ResponseEntity.status(HttpStatus.OK).body(medicoOp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedico(@PathVariable(value = "id") UUID id){
        boolean medicoOp = medicoServices.deletarMedico(id);
        if(!medicoOp){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Medico deletado com sucesso");
    }


}
