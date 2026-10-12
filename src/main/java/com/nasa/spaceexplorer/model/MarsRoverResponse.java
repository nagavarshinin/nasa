package com.nasa.spaceexplorer.model;

import java.util.List;

public class MarsRoverResponse {

    private List<MarsRoverPhoto> photos;

    public List<MarsRoverPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<MarsRoverPhoto> photos) {
        this.photos = photos;
    }
}

class MarsRoverPhoto {
    private Long id;
    private Integer sol;
    private String imgSrc;
    private String earthDate;
    private MarsCamera camera;
    private MarsRoverSummary rover;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public MarsCamera getCamera() {
        return camera;
    }

    public void setCamera(MarsCamera camera) {
        this.camera = camera;
    }

    public MarsRoverSummary getRover() {
        return rover;
    }

    public void setRover(MarsRoverSummary rover) {
        this.rover = rover;
    }
}

class MarsCamera {
    private String id;
    private String name;
    private String fullName;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

class MarsRoverSummary {
    private Long id;
    private String name;
    private String landingDate;
    private String launchDate;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
