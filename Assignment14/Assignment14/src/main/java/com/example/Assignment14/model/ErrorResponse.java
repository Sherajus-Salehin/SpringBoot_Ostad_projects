package com.example.Assignment14.model;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime ts;
    private String message;

    public ErrorResponse(LocalDateTime ts, String message) {
        this.ts = ts;
        this.message = message;
    }

    public LocalDateTime getTs() {
        return ts;
    }

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
