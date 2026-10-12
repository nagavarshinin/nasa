package com.nasa.spaceexplorer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class AsteroidResponse {

    @JsonProperty("element_count")
    private Integer elementCount;

    @JsonProperty("near_earth_objects")
    private Map<String, List<NearEarthObject>> nearEarthObjects;

    public Integer getElementCount() {
        return elementCount;
    }

    public void setElementCount(Integer elementCount) {
        this.elementCount = elementCount;
    }

    public Map<String, List<NearEarthObject>> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(Map<String, List<NearEarthObject>> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }
}

class NearEarthObject {
    private String id;
    private String name;

    @JsonProperty("nasa_jpl_url")
    private String nasaJplUrl;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean potentiallyHazardous;

    @JsonProperty("estimated_diameter")
    private EstimatedDiameter estimatedDiameter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public boolean isPotentiallyHazardous() {
        return potentiallyHazardous;
    }

    public void setPotentiallyHazardous(boolean potentiallyHazardous) {
        this.potentiallyHazardous = potentiallyHazardous;
    }

    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(EstimatedDiameter estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }
}

class EstimatedDiameter {
    private DiameterMetric meters;

    public DiameterMetric getMeters() {
        return meters;
    }

    public void setMeters(DiameterMetric meters) {
        this.meters = meters;
    }
}

class DiameterMetric {
    private Double estimatedDiameterMin;
    private Double estimatedDiameterMax;

    @JsonProperty("estimated_diameter_min")
    public void setEstimatedDiameterMin(Double estimatedDiameterMin) {
        this.estimatedDiameterMin = estimatedDiameterMin;
    }

    @JsonProperty("estimated_diameter_max")
    public void setEstimatedDiameterMax(Double estimatedDiameterMax) {
        this.estimatedDiameterMax = estimatedDiameterMax;
    }

    public Double getEstimatedDiameterMin() {
        return estimatedDiameterMin;
    }

    public Double getEstimatedDiameterMax() {
        return estimatedDiameterMax;
    }
}
