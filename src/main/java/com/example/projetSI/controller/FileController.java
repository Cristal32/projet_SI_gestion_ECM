package com.example.projetSI.controller;

import com.example.projetSI.model.FileData;
import com.example.projetSI.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/file")
public class FileController {
    @Autowired
    private StorageService storageService;

    //contructeur
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    // ================================= get a file =================================

    @GetMapping("/getByFileName/{filename}")
    public ResponseEntity<FileData> getFileByFileName(@PathVariable("filename") String filename){
        FileData fileData = storageService.findFileDataByFileName(filename);
        return new ResponseEntity<>(fileData, HttpStatus.OK);
    }

    // ================================= download a file =================================

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws IOException {
        try {
            FileData fileData = storageService.findFileDataByFileName(fileName);
            if (fileData == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found: " + fileName);
            }

            byte[] fileContent = storageService.downloadFile(fileName);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(fileData.getFileType()));
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileContent);
        } catch (IOException e) {
            System.err.println("Error downloading file: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file: " + fileName);
        }
    }

    // to simply display the file in browser and not download it
	/*
	@GetMapping("/load/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws IOException {
		try {
	        FileData fileData = storageService.findFileDataByFileName(fileName);
	        if (fileData == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found: " + fileName);
	        }

	        byte[] fileContent = storageService.downloadFile(fileName);

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(fileData.getFileType()))
	                .body(fileContent);
	    } catch (IOException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file: " + fileName);
	    }
	}
	*/

    // ================================= upload a file =================================

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
        try {
            FileData uploadFile = storageService.uploadFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(uploadFile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
        }
    }

}
