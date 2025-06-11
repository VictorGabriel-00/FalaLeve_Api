package com.fala.ficr.repositories;

import com.fala.ficr.model.licao.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, UUID>{
}
