package com.build.suchane.repository;

import com.build.suchane.entity.Taluk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalukRepo extends JpaRepository<Taluk,Long> {
}
