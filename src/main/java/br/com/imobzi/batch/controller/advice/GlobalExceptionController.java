package br.com.imobzi.batch.controller.advice;

import br.com.imobzi.batch.handler.BadRequestException;
import br.com.imobzi.batch.handler.ForbiddenException;
import br.com.imobzi.batch.handler.GenericError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericError> handleBadRequestException(BadRequestException exception) {
        log.error(exception.getMessage(), exception);
        final GenericError error = GenericError.builder()
                .code("400")
                .description(exception.getMessage())
                .message("Bad Request")
                .level("Validation")
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<GenericError> handleForbiddenException(ForbiddenException exception) {
        log.error(exception.getMessage(), exception);
        final GenericError error = GenericError.builder()
                .code("403")
                .description(exception.getMessage())
                .message("Forbidden")
                .level("Validation")
                .build();

        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
}
