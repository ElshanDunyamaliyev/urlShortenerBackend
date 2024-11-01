package dev.elshan.urlShortener.controller;

import dev.elshan.urlShortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService service;

    @GetMapping
    public RedirectView getToUrl(@RequestParam String shortUrl){
        return service.findBaseUrlByShortenedUrl(shortUrl);
    }

    @PostMapping("")
    public void createShortUrl(@RequestBody String longUrl){
        service.convertToShortUrl(longUrl);
    }
}
