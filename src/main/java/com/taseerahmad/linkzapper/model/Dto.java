package com.taseerahmad.linkzapper.model;

public class Dto {
    private final String shortUrl;

    public Dto(String shortUrl)
    {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl()
    {
        return shortUrl;
    }
}
