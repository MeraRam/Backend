package com.build.suchane.service;

import com.build.suchane.entity.Taluk;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TalukService {
    public Taluk createTaluk(Taluk taluk);
    public List<Taluk> getAllTaluks();
}
