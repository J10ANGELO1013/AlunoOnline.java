package com.alunoonline.api.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {
    String message() default "A informação passada para o campo não é aceita ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
