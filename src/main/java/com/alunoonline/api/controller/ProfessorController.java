package com.alunoonline.api.controller;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.service.ProfessorService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professor> criar(@RequestBody Professor professor){
        Professor professorCriado = service.criar(professor);

        return ResponseEntity.status(201).body(professorCriado);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List <Professor> listarTodos() {
        return service.listarTodos();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> procurarPeloId(@PathVariable Long id)
    {
        return service.procurarPeloId(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Professor>> buscarPorNome(@PathParam("nome") String nome){
        return  ResponseEntity.ok(service.buscarPorNome(nome));
    }
    @GetMapping("/lista-paginada")

    public ResponseEntity <Page<Professor>> listaprofessorPaginado(
            @RequestParam(defaultValue = "0")    int page,
            @RequestParam(defaultValue = "10")  int size
    ){
        return ResponseEntity.ok(service.listarProfessorPaginado(page, size));
    }

}
