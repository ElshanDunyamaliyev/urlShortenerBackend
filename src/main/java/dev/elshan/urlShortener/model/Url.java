package dev.elshan.urlShortener.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "url")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "shortened_url")
    private String shortenedUrl;
}
