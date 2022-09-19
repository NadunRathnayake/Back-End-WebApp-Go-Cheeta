package com.nadun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO {
    private String driver_id;
//    private String driverId;
    private String f_name;
    private String l_name ;
    private String phone_no;
    private String branch_code;
    private String vehicle_no;
    private String password;

//    public String getDriver_id(){
//        return driver_id;
//    }
//
//    public String getDriverId(){
//        return driverId;
//    }
//
//    public void setDriverId(String dId){
//        this.driver_id=dId;
//        this.driverId=dId;
//    }
//    public void setDriver_Id(String dId){
//        this.driver_id=dId;
//        this.driverId=dId;
//    }
}
