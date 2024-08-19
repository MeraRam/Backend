package com.build.suchane.service;

import com.build.suchane.entity.GovtOffice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GovtOfficeService {

    public GovtOffice createGovtOffice(GovtOffice govtOffice);

    public List<GovtOffice> getAllGovtOffices();
}
