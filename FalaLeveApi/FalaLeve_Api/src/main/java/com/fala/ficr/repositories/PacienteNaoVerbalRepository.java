package com.fala.ficr.repositories;


import com.fala.ficr.model.usuario.PacienteNaoVerbal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacienteNaoVerbalRepository extends JpaRepository<PacienteNaoVerbal, UUID> {
}
