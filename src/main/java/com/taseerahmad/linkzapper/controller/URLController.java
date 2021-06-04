package com.taseerahmad.linkzapper.controller;

import com.taseerahmad.linkzapper.exception.InvalidRequest;
import com.taseerahmad.linkzapper.interfaces.ApiDto;
import com.taseerahmad.linkzapper.model.Response;
import com.taseerahmad.linkzapper.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class URLController {

    private final URLService service;

    @Autowired
    public URLController(URLService service)
    {
        this.service = service;
    }

    @PostMapping("/url/shorten")
    public ResponseEntity<?> generateShortenedUrl(@RequestBody ApiDto apiDto)
    {
        if (apiDto == null || apiDto.getLongUrl() == null) {
            return new ResponseEntity<>(new InvalidRequest(), HttpStatus.OK);
        }

        Response response = service.getShortenedUrl(apiDto.getLongUrl());

        if (response.getDto() != null) {
            return new ResponseEntity<>(response.getDto(), response.getHttpStatus());
        } else {
            return new ResponseEntity<>(response.getErrorResponse(), response.getHttpStatus());
        }
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(
            @PathVariable String shortUrl)
    {
        Response response = service.getOriginalUrl(shortUrl);

        if (response.getDto() != null) {
            return redirect(response.getDto().getShortUrl());

        } else if (response.getHttpStatus() == HttpStatus.NOT_FOUND) {
            return new ResponseEntity<>(response.getErrorResponse(), response.getHttpStatus());

        } else {
            return new ResponseEntity<>(response.getErrorResponse(), response.getHttpStatus());
        }
    }

    private ResponseEntity<?> redirect(String url)
    {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

}
