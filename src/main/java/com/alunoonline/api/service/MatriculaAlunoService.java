package com.alunoonline.api.service;

import com.alunoonline.api.model.MatriculaAluno;

import com.alunoonline.api.repository.MatriculaAlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;




@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository repository;

    public MatriculaAluno criar(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus("MATRICULADO");
        return repository.save(matriculaAluno);
    }

}


