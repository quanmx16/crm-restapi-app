/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanmx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import quanmx.customer.CustomerErrorResponse;
import quanmx.customer.CustomerNotFoundException;

/**
 *
 * @author Dell
 */
@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> customerNotFound2(Exception ex) {
        CustomerErrorResponse error = new CustomerErrorResponse();
        error.setMessage("Exception: " + ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> customerNotFound(CustomerNotFoundException ex) {
        CustomerErrorResponse error = new CustomerErrorResponse();
        error.setMessage("CustomerNotFoundException: " + ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
