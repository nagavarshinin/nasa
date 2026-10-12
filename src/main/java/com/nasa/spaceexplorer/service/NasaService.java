package com.nasa.spaceexplorer.service;

import com.nasa.spaceexplorer.config.NasaProperties;
import com.nasa.spaceexplorer.model.ApodResponse;
import com.nasa.spaceexplorer.model.AsteroidResponse;
import com.nasa.spaceexplorer.model.MarsRoverResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class NasaService {

    private final RestTemplate restTemplate;
    private final NasaProperties nasaProperties;

    public NasaService(RestTemplate restTemplate, NasaProperties nasaProperties) {
        this.restTemplate = restTemplate;
        this.nasaProperties = nasaProperties;
    }

    public ApodResponse getApod(String date) {
        String url = buildUrl("/planetary/apod", Map.of("date", date));
        return restTemplate.getForObject(url, ApodResponse.class);
    }

    public MarsRoverResponse getMarsPhotos(String rover, Integer sol, String camera) {
        String url = buildUrl("/mars-photos/api/v1/rovers/" + rover + "/photos", Map.of(
                "sol", sol,
                "camera", camera,
                "page", 1
        ));
        return restTemplate.getForObject(url, MarsRoverResponse.class);
    }

    public AsteroidResponse getAsteroids(String startDate, String endDate) {
        String url = buildUrl("/neo/rest/v1/feed", Map.of(
                "start_date", startDate,
                "end_date", endDate
        ));
        return restTemplate.getForObject(url, AsteroidResponse.class);
    }

    private String buildUrl(String path, Map<String, Object> queryParams) {
        if (!StringUtils.hasText(nasaProperties.getApiKey())) {
            throw new IllegalStateException("NASA API key is missing. Please set NASA_API_KEY or nasa.api-key.");
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(nasaProperties.getBaseUrl() + path)
                .queryParam("api_key", nasaProperties.getApiKey());

        queryParams.forEach((key, value) -> {
            if (value != null && StringUtils.hasText(String.valueOf(value))) {
                builder.queryParam(key, value);
            }
        });

        return builder.toUriString();
    }
}
