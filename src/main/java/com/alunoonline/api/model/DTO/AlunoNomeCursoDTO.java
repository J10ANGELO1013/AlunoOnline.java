package com.alunoonline.api.model.DTO;

import com.alunoonline.api.model.Aluno;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AlunoNomeCursoDTO {
    private String nome;
    private String curso;

    public AlunoNomeCursoDTO(@NotNull Aluno aluno){
        this.nome = aluno.getNome();
        this.curso = aluno.getCurso();

    }
}
