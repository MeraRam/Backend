package com.build.suchane.service.impl;

import com.build.suchane.entity.Taluk;
import com.build.suchane.repository.TalukRepo;
import com.build.suchane.service.TalukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalukServiceImpl implements TalukService {
    @Autowired
    private TalukRepo talukRepository;

    @Override
    public Taluk createTaluk(Taluk taluk) {
        return talukRepository.save(taluk);
    }

    @Override
    public List<Taluk> getAllTaluks() {
        return talukRepository.findAll();
    }
}
