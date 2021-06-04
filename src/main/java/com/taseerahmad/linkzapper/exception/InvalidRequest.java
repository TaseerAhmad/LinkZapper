package com.taseerahmad.linkzapper.exception;

import com.taseerahmad.linkzapper.interfaces.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public final class InvalidRequest implements ErrorResponse {
    private int status = HttpStatus.BAD_REQUEST.value();
    private String message = "Malformed or invalid URL";
    private String timeStamp = LocalDateTime.now().toString();

    public InvalidRequest() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}

