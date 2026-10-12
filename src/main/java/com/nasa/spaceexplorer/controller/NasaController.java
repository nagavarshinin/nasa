package com.nasa.spaceexplorer.controller;

import com.nasa.spaceexplorer.model.ApodResponse;
import com.nasa.spaceexplorer.model.AsteroidResponse;
import com.nasa.spaceexplorer.model.MarsRoverResponse;
import com.nasa.spaceexplorer.service.NasaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class NasaController {

    private final NasaService nasaService;

    public NasaController(NasaService nasaService) {
        this.nasaService = nasaService;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "service", "NASA Space Explorer",
                "message", "All systems operational"
        );
    }

    @GetMapping("/apod")
    public ResponseEntity<ApodResponse> getApod(@RequestParam(required = false) String date) {
        return ResponseEntity.ok(nasaService.getApod(date));
    }

    @GetMapping("/mars-photos")
    public ResponseEntity<MarsRoverResponse> getMarsPhotos(
            @RequestParam(defaultValue = "curiosity") String rover,
            @RequestParam(defaultValue = "1000") Integer sol,
            @RequestParam(required = false) String camera) {
        return ResponseEntity.ok(nasaService.getMarsPhotos(rover, sol, camera));
    }

    @GetMapping("/asteroids")
    public ResponseEntity<AsteroidResponse> getAsteroids(
            @RequestParam String start_date,
            @RequestParam String end_date) {
        return ResponseEntity.ok(nasaService.getAsteroids(start_date, end_date));
    }
}
