package com.fala.ficr.Repositories;

import com.fala.ficr.Model.comunicacao.Simbolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimboloRepository extends JpaRepository<Simbolo, UUID> {
}
