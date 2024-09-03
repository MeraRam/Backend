package com.build.suchane.service;

import com.build.suchane.entity.District;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DistrictService {

    public District createDistrict(District district);
    public List<District> getAllDistricts();

    public District getDistrictById(long id) throws Exception;
}
