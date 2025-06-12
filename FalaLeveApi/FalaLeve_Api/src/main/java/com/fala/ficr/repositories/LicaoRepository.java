package com.fala.ficr.repositories;

import com.fala.ficr.model.licao.Licao;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LicaoRepository extends JpaRepository<Licao, UUID> {
    @EntityGraph(attributePaths = {"exercicios"})
    Optional<Licao> findById(UUID id);
}
