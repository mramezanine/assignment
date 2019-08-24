package com.mahdi.assignment.paymentplan.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DurationNotValidException extends RuntimeException {
    public DurationNotValidException(String exeption){
        super(exeption);
    }
}
