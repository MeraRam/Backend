package com.build.suchane.controller;

import com.build.suchane.entity.Taluk;
import com.build.suchane.service.TalukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taluks")
public class TalukController {

        @Autowired
        private TalukService talukService;

        @PostMapping
        public ResponseEntity<Taluk> createTaluk(@RequestBody Taluk taluk) {
            try {
                System.out.println("ok");
                System.out.println(taluk);
                return new ResponseEntity<>(talukService.createTaluk(taluk), HttpStatus.CREATED);

            } catch (Exception e) {
                System.out.println(e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping
        public ResponseEntity<List<Taluk>> getAllTaluks() {
            try {
                return new ResponseEntity<>(talukService.getAllTaluks(),HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
