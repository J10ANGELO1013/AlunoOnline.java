package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository repository;

    public Professor criar(Professor professor) {
        return repository.save(professor);
    }
    public List<Professor> listarTodos(){
        return repository.findAll();
    }

    public Optional<Professor> procurarPeloId(Long id){
        return repository.findById(id);

    }
    public void delete(Long id) {
        repository.deleteById(id);

    }

    public List<Professor>buscarPorNome(String nome) {
        return repository.buscarPorNome(nome);
    }

    public Page<Professor> listarProfessorPaginado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
}

