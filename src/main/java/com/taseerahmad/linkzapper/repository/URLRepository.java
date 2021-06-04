package com.taseerahmad.linkzapper.repository;

import com.taseerahmad.linkzapper.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, String> {
    @Query(value = "SELECT long_url FROM url.public.url WHERE short_url=:shortUrl", nativeQuery = true)
    String findOriginalUrl(String shortUrl);
}
