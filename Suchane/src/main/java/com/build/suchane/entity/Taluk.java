package com.build.suchane.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "taluk")
public class Taluk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long talukId;

    @Column(nullable = false)
    private String talukName;

    @ManyToOne
    @JoinColumn(name = "district_id",nullable = false)
    private District district;

    @OneToMany(mappedBy = "taluk",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<GovtOffice> govtOffices;
}
