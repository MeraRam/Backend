package com.build.suchane.service.impl;

import com.build.suchane.entity.File;
import com.build.suchane.entity.GovtOffice;
import com.build.suchane.repository.FileRepository;
import com.build.suchane.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;
    @Override
    public File saveFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    public File updateFile(Long id, File fileDetails) {
        File file = fileRepository.findById(id).orElseThrow(() -> new RuntimeException("File not found with id " + id));
        file.setFileType(fileDetails.getFileType());
        file.setFileData(fileDetails.getFileData());
        file.setNote(fileDetails.getNote());
        file.setGovtOffice(fileDetails.getGovtOffice());
        return fileRepository.save(file);
    }

    @Override
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }

    @Override
    public Optional<File> getFileById(Long id) {
        return fileRepository.findById(id);
    }
}
