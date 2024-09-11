package com.StudentManagementSystem.Application.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ResponseModel> handleIncosistentEditException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String em = objectError.getDefaultMessage();
            errors.put("message", em);
        });
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(errors.get("message"));
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNameNotValidException.class)
    ResponseEntity<ResponseModel> handleInconsistentEditException(StudentNameNotValidException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(e.getMessage());
        responseModel.setData(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SubjectNotValidException.class)
    ResponseEntity<ResponseModel> handleInconsistentEditException(SubjectNotValidException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(e.getMessage());
        responseModel.setData(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
}

