package com.taseerahmad.linkzapper.service;

import com.taseerahmad.linkzapper.exception.InvalidRequest;
import com.taseerahmad.linkzapper.exception.NotFoundError;
import com.taseerahmad.linkzapper.model.Dto;
import com.taseerahmad.linkzapper.model.Response;
import com.taseerahmad.linkzapper.model.URL;
import com.taseerahmad.linkzapper.repository.URLRepository;
import com.taseerahmad.linkzapper.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLService {
    private final URLHash urlHash;
    private final URLRepository repository;

    @Autowired
    public URLService(URLHash urlHash, URLRepository repository)
    {
        this.urlHash = urlHash;
        this.repository = repository;
    }

    public Response getShortenedUrl(String longUrl)
    {
       if (URLUtil.INSTANCE.isUrlValid(longUrl)) {
            URL url = new URL();
            String shortUrl = urlHash.encode(longUrl);

           url.setLongUrl(longUrl);
           url.setShortUrl(shortUrl);
           repository.save(url);

            return new Response(null, new Dto(shortUrl), HttpStatus.OK);
        }

        return new Response(new InvalidRequest(), null, HttpStatus.OK);
    }

//            String url = repository.findOriginalUrl(shortUrl);
    public Response getOriginalUrl(String shortUrl)
    {
        if (!shortUrl.trim().isEmpty() && shortUrl.length() == 8)
        {
            Optional<URL> url = repository.findById(shortUrl);

            if (url.isPresent()) {
                Dto dto = new Dto(url.get().getLongUrl());
                return new Response(null, dto, HttpStatus.OK);
            } else {
                return new Response(new NotFoundError(), null, HttpStatus.OK);
            }
        } else {
            return new Response(new InvalidRequest(), null, HttpStatus.OK);
        }
    }

}
