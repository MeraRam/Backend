package com.build.suchane.service;

import com.build.suchane.entity.File;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FileService {

    public File saveFile(File file);

    public List<File> getAllFiles();

    public File updateFile(Long id, File fileDetails);

    public void deleteFile(Long id);

    Optional<File> getFileById(Long id);
}