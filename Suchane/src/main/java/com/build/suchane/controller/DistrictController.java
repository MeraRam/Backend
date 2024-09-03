package com.build.suchane.controller;

import com.build.suchane.entity.District;
import com.build.suchane.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
        try {
            return new ResponseEntity<>(districtService.createDistrict(district), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<District>> sendDistrict(){
        return new ResponseEntity<>(districtService.getAllDistricts(),HttpStatus.OK);
    }

    @GetMapping( "/{id}")
    public ResponseEntity<District> sendDistrictById(@RequestParam (name="id")long id) throws Exception {
        return  new ResponseEntity<>(districtService.getDistrictById(id), HttpStatus.OK);
    }
}
