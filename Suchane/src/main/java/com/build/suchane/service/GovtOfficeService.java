package com.build.suchane.service;

import com.build.suchane.entity.GovtOffice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GovtOfficeService {

    public GovtOffice createGovtOffice(GovtOffice govtOffice);

    public List<GovtOffice> getAllGovtOffices();


    public Optional<GovtOffice> getGovtOfficeById(Long id);
    }
