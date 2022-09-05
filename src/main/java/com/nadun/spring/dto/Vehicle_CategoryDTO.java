package com.nadun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle_CategoryDTO {
    private String category_id;
    private  String category_name;
    private  String branch_name;
}
