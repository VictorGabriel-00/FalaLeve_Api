package com.fala.ficr.repositories;

import com.fala.ficr.model.comunicacao.Simbolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimboloRepository extends JpaRepository<Simbolo, UUID> {
}
