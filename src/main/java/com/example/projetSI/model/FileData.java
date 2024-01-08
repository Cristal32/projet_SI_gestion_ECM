package com.example.projetSI.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "Fichier")
public class FileData implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4883534278616975922L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_path")
    private String filePath;

    //constructeurs
    public FileData() {}

    public FileData(String fileName, String fileType, String filePath) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
    }

    //getters
    public Long getFileId() {
        return id;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFileType() {
        return fileType;
    }
    public String getFilePath() {
        return filePath;
    }

    //setters
    public void setFileId(Long id) {
        this.id = id;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Builder inner class
    public static class Builder {
        private String fileName;
        private String fileType;
        private String filePath;

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Builder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public FileData build() {
            FileData fileData = new FileData();
            fileData.fileName = this.fileName;
            fileData.fileType = this.fileType;
            fileData.filePath = this.filePath;
            return fileData;
        }
    }

    // Static method to obtain a new builder instance
    public static Builder builder() {
        return new Builder();
    }
}
