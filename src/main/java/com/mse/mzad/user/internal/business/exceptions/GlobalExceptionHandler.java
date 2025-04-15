package com.mse.mzad.user.internal.business.exceptions;

import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<List, List> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(error -> ((FieldError) error).getDefaultMessage()).collect(Collectors.toList());
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), errors, null);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<String, Void> handleRuntimeException(RuntimeException ex) {
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),null);
    }
}
