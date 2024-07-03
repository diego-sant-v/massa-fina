package com.backend.pizzaria.dto;

public class FileDTO {
    private Long id;
    private UserLoggedDTO user;
    private String relativePath;
    private Boolean file;
    private Boolean image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserLoggedDTO getUser() {
        return user;
    }

    public void setUser(UserLoggedDTO user) {
        this.user = user;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public Boolean getFile() {
        return file;
    }

    public void setFile(Boolean file) {
        this.file = file;
    }

    public Boolean getImage() {
        return image;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }
}
