package com.ims.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleSupplierException(IdNotFoundException ex, WebRequest request)
    {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }
    
   /* @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductException(ProductIdNotFoundException ex, WebRequest request)
    {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }
    
    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCustomerException(CustomerIdNotFoundException ex, WebRequest request)
    {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }
    
    @ExceptionHandler(DefectiveItemsIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDefectiveItemsException(DefectiveItemsIdNotFoundException ex, WebRequest request)
    {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }
    
    @ExceptionHandler(SalesIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleSalesException(SalesIdNotFoundException ex, WebRequest request)
    {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }*/

}