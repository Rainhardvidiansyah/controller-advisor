package com.example.demo.handling;

import com.example.demo.exception.ProductCannotBeSaveException;
import com.example.demo.response.ApiErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@ControllerAdvice @Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerAdviser extends ResponseEntityExceptionHandler {


//    @ExceptionHandler(NoProductException.class)
//    public ResponseEntity<?> productHandlerException(NoProductException noProductException, WebRequest request){
//        Map<String, Object> map = new HashMap<>();
//        map.put("Date", LocalDateTime.now());
//        map.put("Result", "Data not found");
//        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
//    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("date", LocalDateTime.now());
        body.put("status", status.value());

        List<String> error = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        body.put("error", error);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        String err = "There's an error in your input";

        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }

    private ResponseEntity<Object> buildResponse(ApiErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(ProductCannotBeSaveException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            ProductCannotBeSaveException ex) {
        ApiErrorResponse apiError = new ApiErrorResponse(NOT_ACCEPTABLE);
        apiError.setMessage(ex.getMessage());
        return buildResponse(apiError);
    }

}
