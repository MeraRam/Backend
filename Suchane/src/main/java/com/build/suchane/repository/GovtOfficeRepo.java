package com.build.suchane.repository;

import com.build.suchane.entity.GovtOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovtOfficeRepo extends JpaRepository<GovtOffice, Long> {
}
