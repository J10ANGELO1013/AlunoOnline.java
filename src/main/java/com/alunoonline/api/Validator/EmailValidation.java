package com.alunoonline.api.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)

public @interface EmailValidation {
    String message() default "Este email nao é aceito" ;
    Class<?>[] group() default{};

    Class<? extends Payload>[] payload() default{};
}
