package dev.elshan.urlShortener.model;

import jakarta.persistence.*;

@Entity
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "shortened_url")
    private String shortenedUrl;
}
