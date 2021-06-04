package com.taseerahmad.linkzapper.model;

import com.taseerahmad.linkzapper.interfaces.ErrorResponse;
import org.springframework.http.HttpStatus;

public final class Response {
    private final Dto dto;
    private final HttpStatus httpStatus;
    private final ErrorResponse errorResponse;

    public Response(ErrorResponse errorResponse, Dto dto, HttpStatus httpStatus)
    {
        this.dto = dto;
        this.httpStatus = httpStatus;
        this.errorResponse = errorResponse;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Dto getDto()
    {
        return dto;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
