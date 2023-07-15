package com.alunoonline.api.Validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailValidation, String> {


        private String message;

        @Override
        public void initialize(EmailValidation constraintAnnotation) {
            message = constraintAnnotation.message();
        }


        @Override
        public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
            if(nome.contains("Fuji.com")){
                return true;
            }
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message + nome)//
                    .addConstraintViolation();
            return false;
        }
    }

