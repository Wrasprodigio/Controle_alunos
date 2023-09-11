package com.durc.crud.service;

import com.durc.crud.entidade.Estudante;
import com.durc.crud.repository.EstudanteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteImplements implements EstudanteService {

    @Autowired
    private EstudanteRepositorio estudanteRepositorio;

    @Override
    public List<Estudante> listarTodosOsEstudantes() {
        return estudanteRepositorio.findAll();
    }

    @Override
    public Estudante novoEstudante(Estudante estudante) {
        return estudanteRepositorio.save(estudante);
    }

    @Override
    public Estudante obterEstudantePorId(Long id) {
        return estudanteRepositorio.findById(id).get();
    }

    @Override
    public Estudante atualizarEstudante(Estudante estudante) {
        return estudanteRepositorio.save(estudante);
    }

    @Override
    public void excluirEstudante(Long id) {
        estudanteRepositorio.deleteById(id);
    }
}
