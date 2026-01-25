package com.fala.ficr.Services;

import com.fala.ficr.Dto.PacienteNaoVerbalDto;
import com.fala.ficr.Model.usuario.PacienteNaoVerbal;
import com.fala.ficr.Repositories.PacienteNaoVerbalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteNaoVerbalService {

    @Autowired
    private PacienteNaoVerbalRepository pacienteNaoVerbalRepository;

    @Transactional
    public PacienteNaoVerbal criarUsuarioNaoVerbal(PacienteNaoVerbalDto pacienteNaoVerbalDto){
        var paciente = new PacienteNaoVerbal();
        BeanUtils.copyProperties(pacienteNaoVerbalDto, paciente);
        return pacienteNaoVerbalRepository.save(paciente);
    }


    public List<PacienteNaoVerbal> listarTodosPacientes(){
        return pacienteNaoVerbalRepository.findAll();
    }


    public Optional<PacienteNaoVerbal> buscarPorId(UUID id){
        return pacienteNaoVerbalRepository.findById(id);
    }


    @Transactional
    public Optional<PacienteNaoVerbal> atualizarUsuario(UUID id, PacienteNaoVerbalDto pacienteNaoVerbalDto){
        Optional<PacienteNaoVerbal> pacienteOp = pacienteNaoVerbalRepository.findById(id);
        if(pacienteOp.isEmpty()){
            return Optional.empty();
        }
        var paciente = pacienteOp.get();
        BeanUtils.copyProperties(pacienteNaoVerbalDto, paciente);
        return Optional.of(pacienteNaoVerbalRepository.save(paciente));
    }



    @Transactional
    public boolean deletarPaciente(UUID id){
        Optional<PacienteNaoVerbal> pacienteOp = pacienteNaoVerbalRepository.findById(id);
        if(pacienteOp.isEmpty()){
            return false;
        }


        pacienteNaoVerbalRepository.delete(pacienteOp.get());
        return true;
    }



}
