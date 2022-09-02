package com.nadun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO {
    private String driver_id;
    private String f_name;
    private String l_name ;
    private String phone_no;
    private String branch_code;
    private String vehicle_no;
}
