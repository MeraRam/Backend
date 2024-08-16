package com.build.suchane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "office_type")
public class OfficeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    @Column(nullable = false)
    private String officeName;

    @OneToMany(mappedBy = "officeType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GovtOffice> govtOffices;

}
