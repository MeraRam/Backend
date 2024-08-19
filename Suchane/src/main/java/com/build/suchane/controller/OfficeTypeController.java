package com.build.suchane.controller;


import com.build.suchane.entity.OfficeType;
import com.build.suchane.service.OfficeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/office-types")
public class OfficeTypeController {

    @Autowired
    private OfficeTypeService officeTypeService;

    @PostMapping
    public ResponseEntity<OfficeType> createOfficeType(@RequestBody OfficeType officeType) {
        try {
            return new ResponseEntity<>(officeTypeService.createOfficeType(officeType), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllOfficeTypes() {
        return new ResponseEntity<>(officeTypeService.getAllOfficeTypes(), HttpStatus.OK);
    }
}