package com.alunoonline.api.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NomeValidator.class)

public @interface NomeValidation {
    String message() default "A informação passada para o campo nao é aceita" ;
    Class<?>[] group() default{};

    Class<? extends Payload>[] payload() default{};
}

