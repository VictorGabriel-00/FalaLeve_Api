package com.fala.ficr.repositories;

import com.fala.ficr.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, UUID> {
}
