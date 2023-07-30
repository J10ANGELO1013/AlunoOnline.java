package com.alunoonline.api.model.DTO;

import com.alunoonline.api.Validator.EmailValidation;
import com.alunoonline.api.Validator.NomeValidation;
import lombok.Data;

@Data
public class AlunoDTO {

    private Long id;
    @NomeValidation
    private String nome;
    @EmailValidation
    private String email;
    private String curso;
}
