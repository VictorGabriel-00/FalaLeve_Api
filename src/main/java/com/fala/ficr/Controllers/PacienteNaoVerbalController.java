package com.fala.ficr.Controllers;

import com.fala.ficr.Dto.PacienteNaoVerbalDto;
import com.fala.ficr.Model.usuario.PacienteNaoVerbal;
import com.fala.ficr.Repositories.PacienteNaoVerbalRepository;
import com.fala.ficr.Services.PacienteNaoVerbalService;
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
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteNaoVerbalController {

    @Autowired
    PacienteNaoVerbalService pacienteNaoVerbalService;


    @PostMapping
    public ResponseEntity<PacienteNaoVerbal> saveUsuarioNaoVerbal(@RequestBody @Valid PacienteNaoVerbalDto pacienteNaoVerbalDto) {
        PacienteNaoVerbal pacienteNaoVerbal = pacienteNaoVerbalService.criarUsuarioNaoVerbal(pacienteNaoVerbalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteNaoVerbal);
    }

    @GetMapping
    public ResponseEntity<List<PacienteNaoVerbal>> getUsuario(){
        List<PacienteNaoVerbal> pacienteNaoVerbals = pacienteNaoVerbalService.listarTodosPacientes();
        return ResponseEntity.status(HttpStatus.OK).body(pacienteNaoVerbals);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneUsuarioNaoVerbal(@PathVariable(value = "id") UUID id){
        Optional<PacienteNaoVerbal> usuarioNaoVerbalOp = pacienteNaoVerbalService.buscarPorId(id);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioNaoVerbalOp.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> upUsuarioNaoVerbal(@PathVariable(value = "id") UUID id,
                                          @RequestBody @Valid PacienteNaoVerbalDto pacienteNaoVerbalDto){
        Optional<PacienteNaoVerbal> usuarioNaoVerbalOp = pacienteNaoVerbalService.atualizarUsuario(id,pacienteNaoVerbalDto);
        if(usuarioNaoVerbalOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        var medicoAdm = usuarioNaoVerbalOp.get();
        BeanUtils.copyProperties(pacienteNaoVerbalDto, medicoAdm);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioNaoVerbalOp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUsuarioNaoVerbal(@PathVariable(value = "id") UUID id){
        boolean usuarioNaoVerbalOp = pacienteNaoVerbalService.deletarPaciente(id);
        if(!usuarioNaoVerbalOp){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com suceeso");
    }


}
