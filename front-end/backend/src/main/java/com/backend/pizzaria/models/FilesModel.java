package com.backend.pizzaria.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "files")
public class FilesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne // Many files can be associated with one user
    @JoinColumn(name = "user_id") // name of the foreign key column in the files table
    private UsersModel user;

    @Column(name = "relative_path")
    private String relativePath;

    @Column(name = "is_file")
    private Boolean isFile;

    @Column(name = "is_image")
    private Boolean isImage;

    @Column(name = "file_size")
    private Number fileSize;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public Boolean getFile() {
        return isFile;
    }

    public void setFile(Boolean file) {
        isFile = file;
    }

    public Boolean getImage() {
        return isImage;
    }

    public void setImage(Boolean image) {
        isImage = image;
    }

    public Number getFileSize() {
        return fileSize;
    }

    public void setFileSize(Number fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
