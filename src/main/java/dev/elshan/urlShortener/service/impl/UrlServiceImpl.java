package dev.elshan.urlShortener.service.impl;

import dev.elshan.urlShortener.model.Url;
import dev.elshan.urlShortener.repository.UrlRepository;
import dev.elshan.urlShortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
@RequiredArgsConstructor
@Slf4j
public class UrlServiceImpl implements UrlService {
    private final UrlRepository repository;

    @Override
    public RedirectView findBaseUrlByShortenedUrl(String url) {
        return repository
                .findByShortenedUrl(url)
                .map(foundedUrl -> {
                    RedirectView redirectView = new RedirectView();
                    redirectView.setUrl(foundedUrl.getOriginalUrl());
                    return redirectView;
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Base Url is not found"));
    }

    @Override
    public void convertToShortUrl(String longUrl) {
        var shortenedUrl =  RandomStringUtils.randomAlphanumeric(8);
        var urlEntity = Url.builder().originalUrl(longUrl).shortenedUrl(shortenedUrl).build();
        repository.save(urlEntity);
    }
}
