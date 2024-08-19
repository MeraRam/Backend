package com.build.suchane.controller;

import com.build.suchane.entity.GovtOffice;
import com.build.suchane.service.GovtOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/govt-offices")
public class GovtOfficeController {

    @Autowired
    private GovtOfficeService govtOfficeService;

    @PostMapping
    public GovtOffice createGovtOffice(@RequestBody GovtOffice govtOffice) {
        return govtOfficeService.createGovtOffice(govtOffice);
    }

    @GetMapping
    public List<GovtOffice> getAllGovtOffices() {
        return govtOfficeService.getAllGovtOffices();
    }
}
