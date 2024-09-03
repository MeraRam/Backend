package com.build.suchane.controller;

import com.build.suchane.entity.File;
import com.build.suchane.entity.FileType;
import com.build.suchane.entity.GovtOffice;
import com.build.suchane.service.FileService;
import com.build.suchane.service.GovtOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private GovtOfficeService govtOfficeService;

    @PostMapping(consumes = "multipart/form-data")
    public File uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("note") String note,
            @RequestParam("govtOfficeId") Long govtOfficeId) throws IOException {

        // Validate the file type (only PDF allowed)
        if (!file.getContentType().equals("application/pdf")) {
            throw new IllegalArgumentException("Only PDF files are allowed.");
        }


        GovtOffice govtOffice = (GovtOffice) govtOfficeService.getGovtOfficeById(govtOfficeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid GovtOffice ID"));

        // Create a new File entity and set its properties
        File newFile = new File();
        newFile.setFileType(FileType.PDF);
        newFile.setFileData(file.getBytes());
        newFile.setNote(note);
        newFile.setGovtOffice(govtOffice);

        return fileService.saveFile(newFile);
    }

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<?> downloadFile(@PathVariable Long id) {
        Optional<File> fileOptional = fileService.getFileById(id);
        if (!fileOptional.isPresent()) {
            return new ResponseEntity<>("Data not found for id => "+id,HttpStatus.NOT_FOUND);
        }

        File file = (File) fileOptional.get();

        // Convert the file data to a ByteArrayResource
        ByteArrayResource resource = new ByteArrayResource(file.getFileData());

        // Determine the content type (this example assumes only PDF, you can modify as needed)
        String contentType = "application/pdf";

        // Build the HTTP headers for file download
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file_" + file.getFileId() + ".pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.getFileData().length)
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }

    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public File updateFile(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file,
            @RequestParam("note") String note,
            @RequestParam("govtOfficeId") Long govtOfficeId) throws IOException {

        // Validate the file type (only PDF allowed)
        if (!file.getContentType().equals("application/pdf")) {
            throw new IllegalArgumentException("Only PDF files are allowed.");
        }

        // Fetch the related GovtOffice entity
        GovtOffice govtOffice = (GovtOffice) govtOfficeService.getGovtOfficeById(govtOfficeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid GovtOffice ID"));

        // Update the File entity
        File updatedFile = (File) fileService.getFileById(id)
                .orElseThrow(() -> new IllegalArgumentException("File not found with id " + id));

        updatedFile.setFileType(FileType.PDF);
        updatedFile.setFileData(file.getBytes());
        updatedFile.setNote(note);
        updatedFile.setGovtOffice(govtOffice);

        return fileService.saveFile(updatedFile);
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
    }
}