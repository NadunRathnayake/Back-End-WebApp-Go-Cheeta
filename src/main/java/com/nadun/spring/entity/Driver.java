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

public class Driver {
    @Id
    private String driverId;
    private String f_name;
    private String l_name ;
    private String phone_no;
    private String branch_code;
    private String vehicle_no;
    private String password;
}
