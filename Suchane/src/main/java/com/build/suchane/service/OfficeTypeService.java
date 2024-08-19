package com.build.suchane.service;

import com.build.suchane.entity.OfficeType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfficeTypeService {

    public OfficeType createOfficeType(OfficeType officeType);
    public List<OfficeType> getAllOfficeTypes();
}
