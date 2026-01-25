package com.fala.ficr.Repositories;

import com.fala.ficr.Model.licao.Licao;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LicaoRepository extends JpaRepository<Licao, UUID> {
    @EntityGraph(attributePaths = {"exercicios"})
    Optional<Licao> findById(UUID id);
}
