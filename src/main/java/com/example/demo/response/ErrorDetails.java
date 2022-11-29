package com.example.demo.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor @Getter @Setter
public class ErrorDetails {

    private LocalDateTime date;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime date, String message, String details) {
        super();
        this.date = date;
        this.message = message;
        this.details = details;
    }
}
