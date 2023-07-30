package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {
    @Mock
    AlunoRepository alunoRepository;
    @InjectMocks
    AlunoService alunoService;

    final long ID_ALUNO = 100l;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void criar() {
    }

    @Test
    void listarTodos() {
        Aluno aluno =Aluno.builder()
                .email("rodrio@uol.com.br")
                .nome("Rodrigo Fujioka")
                .curso("computação")
                .id(ID_ALUNO)
                .build();
        Mockito.when(alunoRepository.findAll())
                .thenReturn((Arrays.asList(aluno)));

        List<Aluno> lista = alunoService.listarTodos();
        Assertions
                .assertFalse(lista.isEmpty());
    }

    @Test
    void procurarPeloId() {
        long ID_CONSULTA = 200l
        Aluno aluno = Aluno.builder() .id(ID_CONSULTA).nome("Rodrigo").build();
        Mockito.when(alunoRepository.findById(ID_CONSULTA))
                .thenReturn(Optional.of(aluno));

        Optional<Aluno> alunoRetorno
                =alunoService.procurarPeloId(ID_CONSULTA);

        Assertions.assertEquals("Rodrigo", alunoRetorno.get().getNome());
    }

    @Test
    void buscarPorId() {
    }

    @Test
    void delete() {
        alunoService.delete(ID_ALUNO);
        Mockito.verify(alunoRepository,
                Mockito.times(1))
                .deleteById(ID_ALUNO);
    }

    @Test
    void buscarPorNome() {
    }

    @Test
    void buscarPorEmail() {
    }

    @Test
    void listarAlunoPaginado() {
    }
}