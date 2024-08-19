package com.build.suchane.service.impl;

import com.build.suchane.entity.District;
import com.build.suchane.repository.DistrictRepo;
import com.build.suchane.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepo districtRepository;

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
}