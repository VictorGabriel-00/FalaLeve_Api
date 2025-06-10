package com.fala.ficr.repositories;


import com.fala.ficr.model.usuario.UsuarioNaoVerbal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioNaoVerbalRepository extends JpaRepository<UsuarioNaoVerbal, UUID> {
}
