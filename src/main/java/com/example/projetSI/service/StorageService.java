package com.example.projetSI.service;

import com.example.projetSI.modal.FileData;
import com.example.projetSI.repository.FileDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private FileDataDao fileDataDao;

    private final String FOLDER_PATH = "C:\\Users\\HP\\Documents\\FileSystem\\";

    //============================= upload a file =============================

    public FileData uploadFile(MultipartFile file) throws Exception{
        try {
            //upload the file, if same name, gets replaced
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            if (fileName.contains("..")) {
                throw new IllegalArgumentException("Invalid file name: " + fileName);
            }

            String filePath = FOLDER_PATH + file.getOriginalFilename();

            file.transferTo(new File(filePath));

            //find the fileData in db
            Optional<FileData> existingFileDataOptional = fileDataDao.findByFileName(fileName);

            FileData result = null;

            //if it exists, update it with the new file's data
            if (existingFileDataOptional.isPresent()) {
                FileData existingFileData = existingFileDataOptional.get();
                existingFileData.setFileType(file.getContentType());
                existingFileData.setFilePath(filePath);

                result = fileDataDao.save(existingFileData);
            }
            else {
                result = fileDataDao.save(FileData.builder()
                        .fileName(file.getOriginalFilename())
                        .fileType(file.getContentType())
                        .filePath(FOLDER_PATH + file.getOriginalFilename())
                        .build());
            }

            return result;
        }
        catch(IOException e) {
            throw new Exception("Error uploading file: " + e.getMessage());
        }

    }

    //============================= download a file =============================

    public byte[] downloadFile(String fileName) throws IOException {
        Optional<FileData> fileDataOptional = fileDataDao.findByFileName(fileName);

        if (fileDataOptional.isPresent()) {
            //String filePath = fileData.getFilePath();
            String filePath = FOLDER_PATH + fileName;

            try {
                Path path = Paths.get(filePath);
                return Files.readAllBytes(path);
            } catch (IOException e) {
                throw new IOException("Error reading file: " + fileName, e);
            }
        } else {
            throw new FileNotFoundException("File not found: " + fileName);
        }
    }

    // ============================= find file by its name =============================

    public FileData findFileDataByFileName(String filename) {
        return fileDataDao.findByFileName(filename).orElse(null);
    }
}
