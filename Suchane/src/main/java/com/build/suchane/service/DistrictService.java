package com.build.suchane.service;

import com.build.suchane.entity.District;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {

    public District createDistrict(District district);
    public List<District> getAllDistricts();
}
