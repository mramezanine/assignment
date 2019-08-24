package com.mahdi.assignment.paymentplan.conroller;

import com.mahdi.assignment.paymentplan.exeptions.DurationNotValidException;
import com.mahdi.assignment.paymentplan.model.CustomErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DurationNotValidException.class)
    public final ResponseEntity<CustomErrorMessage> handleUserNotFoundException(DurationNotValidException ex, WebRequest request) {
        CustomErrorMessage customMessage = new CustomErrorMessage(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(customMessage, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}