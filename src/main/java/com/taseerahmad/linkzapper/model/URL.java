package com.taseerahmad.linkzapper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class URL {
    @Id
    private String shortUrl;
    private String longUrl;

    public URL(String shortUrl, String longUrl) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }

    public URL() {

    }

    public String getLongUrl()
    {
        return longUrl;
    }

    public void setLongUrl(String longUrl)
    {
        this.longUrl = longUrl;
    }

    public String getShortUrl()
    {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl)
    {
        this.shortUrl = shortUrl;
    }

}
