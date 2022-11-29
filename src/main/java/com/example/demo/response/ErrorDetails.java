package com.example.demo.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ErrorDetails {

    private LocalDateTime date;
    private String message;

    private int status;
    private String details;

    public ErrorDetails(){
        super();
        this.date = LocalDateTime.now();
    }

    public ErrorDetails(LocalDateTime date, String message, int status, String details) {
        super();
        this.message = message;
        this.status = status;
        this.details = details;
    }
}
