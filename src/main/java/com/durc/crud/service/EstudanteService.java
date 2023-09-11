package com.durc.crud.service;

import com.durc.crud.entidade.Estudante;

import java.util.List;

public interface EstudanteService {

    List<Estudante> listarTodosOsEstudantes();

    Estudante novoEstudante(Estudante estudante);

    Estudante obterEstudantePorId(Long id);

    Estudante atualizarEstudante(Estudante estudante);

    void excluirEstudante(Long id);

}
