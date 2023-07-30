package com.alunoonline.api.model.DTO;

import lombok.Data;

@Data
public class DisciplinasAlunoDTO {
    private String nomeDisciplina;
    private String professorDisciplina;
    private Double nota1;
    private Double nota2;
    private Double media;
    private String status;

}
