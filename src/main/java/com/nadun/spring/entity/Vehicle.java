package com.nadun.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {
    @Id
    private String vehicle_no ;
    private String vehicle_model;
    private String vehicle_category;
    private String branch_code;
    private String driver_id;
}
