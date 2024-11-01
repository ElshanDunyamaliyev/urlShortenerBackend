package dev.elshan.urlShortener.repository;

import dev.elshan.urlShortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url,Long> {
}
