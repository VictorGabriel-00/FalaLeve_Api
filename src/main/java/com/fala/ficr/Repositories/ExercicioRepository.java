package com.fala.ficr.Repositories;

import com.fala.ficr.Model.licao.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, UUID>{
}
