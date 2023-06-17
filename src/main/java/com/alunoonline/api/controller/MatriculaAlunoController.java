package com.alunoonline.api.controller;

import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.service.DisciplinaService;
import com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {
    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaAluno> matricularAluno(
            @RequestBody MatriculaAluno matriculaAluno) {

        MatriculaAluno matriculaAlunoCriado = service.criar(matriculaAluno);
        return ResponseEntity.status(201).body(matriculaAlunoCriado);
    }


}
