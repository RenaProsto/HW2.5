package com.example.hw25;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super();
    }

}
