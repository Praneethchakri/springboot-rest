package com.employee.data.service.employementExchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerEmployeeNotFoundException(EmployeeNotFoundException e, WebRequest webRequest){
       ErrorDetails ed =  new ErrorDetails(
                LocalDateTime.now(),
                e.getMessage(),
                webRequest.getDescription(false),
                "EMPLOYEE NOT FOUND"
        );
                 return  new ResponseEntity<ErrorDetails>(ed, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(EmailAlreadyExistException.class)
        public ResponseEntity<ErrorDetails> handlerEmailAlreadyExistException(EmailAlreadyExistException e,WebRequest webRequest){

           ErrorDetails ed =  new ErrorDetails(
               LocalDateTime.now(),
               e.getMessage(),
                   webRequest.getDescription(false),
               "EMAIL_ALREADY_EXIST"
            ) ;
           return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value = Exception.class)
        public ResponseEntity<ErrorDetails> handlerGlobalException(Exception ex,WebRequest webRequest){
            ErrorDetails ed =  new ErrorDetails(
                    LocalDateTime.now(),
                    ex.getMessage(),
                    webRequest.getDescription(false),
                    "Internal Server Error"
            ) ;
            return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
