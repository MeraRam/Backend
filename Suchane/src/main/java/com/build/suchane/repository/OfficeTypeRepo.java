package com.build.suchane.repository;

import com.build.suchane.entity.OfficeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeTypeRepo extends JpaRepository<OfficeType, Long> {
}
