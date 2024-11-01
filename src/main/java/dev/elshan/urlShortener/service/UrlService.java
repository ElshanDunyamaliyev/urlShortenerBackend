package dev.elshan.urlShortener.service;

import dev.elshan.urlShortener.model.Url;
import org.springframework.web.servlet.view.RedirectView;

public interface UrlService {

    RedirectView findBaseUrlByShortenedUrl(String url);
    void convertToShortUrl(String longUrl);
}
