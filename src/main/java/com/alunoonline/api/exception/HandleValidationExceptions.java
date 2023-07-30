package com.alunoonline.api.exception;


import com.alunoonline.api.model.DTO.ErroDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@Order
@Log4j2
@ControllerAdvice
public class HandleValidationExceptions {

    @ExceptionHandler(NoSuchFieldException.class)
    @ResponseBody
    public ResponseEntity<ErroDTO> handleException(Exception e) {

        ErroDTO erroCapturado =
                ErroDTO.builder()
                        .erro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .detalhes(e.getMessage())
                        .build();


        log.info("Erro", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroCapturado);
    }
}
