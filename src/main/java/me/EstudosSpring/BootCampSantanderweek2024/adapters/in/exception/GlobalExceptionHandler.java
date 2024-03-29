package me.EstudosSpring.BootCampSantanderweek2024.adapters.in.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.EstudosSpring.BootCampSantanderweek2024.domain.exception.ChampionsNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ChampionsNotFoundException.class)
    public ResponseEntity<ApiError> handlerDomainException(ChampionsNotFoundException domainError){
        return ResponseEntity
        .unprocessableEntity()
        .body(new ApiError(domainError.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handlerDomainException(Exception unexpectedError){
        String message = "Ops!. Ocorreu um erro inesperado.";
        logger.error(message, unexpectedError);
        return ResponseEntity
        .internalServerError()
        .body(new ApiError(message));
    }



    public record ApiError(String message){}
}
