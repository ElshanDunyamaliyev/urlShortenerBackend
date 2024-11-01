package dev.elshan.urlShortener.repository;

import dev.elshan.urlShortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url,Long> {

    Optional<Url> findByShortenedUrl(String shortenedUrl);
}
