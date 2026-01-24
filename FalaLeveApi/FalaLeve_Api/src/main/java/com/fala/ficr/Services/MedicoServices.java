package com.fala.ficr.Services;

import com.fala.ficr.Dto.MedicoRecordDto;
import com.fala.ficr.Model.usuario.Medico;
import com.fala.ficr.Model.usuario.PacienteNaoVerbal;
import com.fala.ficr.Repositories.MedicoRepository;
import com.fala.ficr.Repositories.PacienteNaoVerbalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicoServices {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteNaoVerbalRepository pacienteNaoVerbalRepository;

    public boolean assumirPaciente( UUID idMedico, UUID idPaciente){
        Optional<Medico> medicoOpt = medicoRepository.findById(idMedico);
        Optional<PacienteNaoVerbal> pacienteOp = pacienteNaoVerbalRepository.findById(idPaciente);

        if(medicoOpt.isPresent() && pacienteOp.isPresent()){
            Medico medico = medicoOpt.get();
            PacienteNaoVerbal paciente = pacienteOp.get();


            paciente.setMedico(medico);
            pacienteNaoVerbalRepository.save(paciente);

            return true;
        }
        return false;
    }

    @Transactional
    public Medico criarMedico(MedicoRecordDto medicoRecordDto){
        var medico = new Medico();
        BeanUtils.copyProperties(medicoRecordDto, medico);
        return medicoRepository.save(medico);
    }


    public List<Medico> listarTodosMedicos(){
        return medicoRepository.findAll();
    }


    public Optional<Medico> buscarPorId(UUID id){
        return medicoRepository.findById(id);
    }


    @Transactional
    public Optional<Medico> atualizarMedico(UUID id, MedicoRecordDto medicoRecordDto){
        Optional<Medico> medicoOp = medicoRepository.findById(id);
        if(medicoOp.isEmpty()){
            return Optional.empty();
        }
        var medico = medicoOp.get();
        BeanUtils.copyProperties(medicoRecordDto, medico);
        return Optional.of(medicoRepository.save(medico));
    }



    @Transactional
    public boolean deletarMedico(UUID id){
        Optional<Medico> medicoOp = medicoRepository.findById(id);
        if(medicoOp.isEmpty()){
            return false;
        }


        medicoRepository.delete(medicoOp.get());
        return true;
    }


}
