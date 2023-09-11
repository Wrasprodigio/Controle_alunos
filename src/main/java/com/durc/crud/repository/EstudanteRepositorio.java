package com.durc.crud.repository;

import com.durc.crud.entidade.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepositorio extends JpaRepository<Estudante, Long> {
}
