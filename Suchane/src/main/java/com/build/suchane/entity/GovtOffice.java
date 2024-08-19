package com.build.suchane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "govt_offices")
public class GovtOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gId;

    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false)
    private OfficeType officeType;

    @ManyToOne
    @JoinColumn(name = "taluk_id", nullable = false)
    private Taluk taluk;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String pincode;

    @Column(nullable = false)
    private boolean status = true;

    @Column(nullable = false)
    private String phoneNumber;

}
