package com.build.suchane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "district_table")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;

    @Column(nullable = false)
    private String districtName;

    @OneToMany(mappedBy = "district",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Taluk> taluks;
}