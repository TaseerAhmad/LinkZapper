package com.taseerahmad.linkzapper.service;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.taseerahmad.linkzapper.interfaces.HashEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class URLHash implements HashEncoder {

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public String encode(String url)
    {
        LocalDateTime time = LocalDateTime.now();
        String concatenatedUrl = url.concat(time.toString());
        Charset charset = StandardCharsets.UTF_8;
        HashCode hashCode = Hashing.murmur3_32().hashString(concatenatedUrl, charset);

        return hashCode.toString();
    }
}
