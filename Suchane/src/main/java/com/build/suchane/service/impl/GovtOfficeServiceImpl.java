package com.build.suchane.service.impl;

import com.build.suchane.entity.GovtOffice;
import com.build.suchane.repository.GovtOfficeRepo;
import com.build.suchane.service.GovtOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GovtOfficeServiceImpl implements GovtOfficeService {

    @Autowired
    private GovtOfficeRepo govtOfficeRepository;

    @Override
    public GovtOffice createGovtOffice(GovtOffice govtOffice) {
        return govtOfficeRepository.save(govtOffice);
    }

    @Override
    public List<GovtOffice> getAllGovtOffices() {
        return govtOfficeRepository.findAll();
    }

    @Override
    public Optional<GovtOffice> getGovtOfficeById(Long id) {
        return govtOfficeRepository.findById(id);
    }
}
