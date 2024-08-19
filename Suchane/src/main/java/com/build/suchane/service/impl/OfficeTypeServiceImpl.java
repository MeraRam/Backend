package com.build.suchane.service.impl;

import com.build.suchane.entity.OfficeType;
import com.build.suchane.repository.OfficeTypeRepo;
import com.build.suchane.service.OfficeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeTypeServiceImpl implements OfficeTypeService {

    @Autowired
    private OfficeTypeRepo officeTypeRepository;

    @Override
    public OfficeType createOfficeType(OfficeType officeType) {
        return officeTypeRepository.save(officeType);
    }
    @Override
    public List<OfficeType> getAllOfficeTypes() {
        return officeTypeRepository.findAll();
    }
}
