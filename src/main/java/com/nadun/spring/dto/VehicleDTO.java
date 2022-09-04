package com.nadun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class VehicleDTO {
   private String vehicle_no ;
   private String vehicle_model;
   private String vehicle_category;
   private String branch_code;
   private String driver_id;
}
