package me.EstudosSpring.BootCampSantanderweek2024.adapters.in;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import me.EstudosSpring.BootCampSantanderweek2024.domain.exception.ChampionsNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ChampionsNotFoundException.class)
    public ApiError handlerDomainException(ChampionsNotFoundException domainError){
        return new ApiError(domainError.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiError handlerDomainException(Exception domainError){
        return new ApiError("Ops! Ocorreu um erro inesperado.");
    }


    public record ApiError(String message){}
}
