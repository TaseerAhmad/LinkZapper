package com.taseerahmad.linkzapper.interfaces;

public class ApiDto {
    private String longUrl;

    public ApiDto(String longUrl) {
        this.longUrl = longUrl;
    }

    public ApiDto() {

    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
