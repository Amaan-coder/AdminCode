package com.example.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.employee.dto.ResponseDto;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ValidationFailedException.class)
    @ResponseBody
    public ResponseEntity<ResponseDto> handleValidationFailedException(HttpServletRequest request, Exception ex) {
    	ValidationFailedException error =(ValidationFailedException) ex;
        ResponseDto resp = new ResponseDto(true, error.getStatus(), ex.getMessage());
        return new ResponseEntity<ResponseDto>(resp, HttpStatus.PRECONDITION_FAILED);
    }
}
