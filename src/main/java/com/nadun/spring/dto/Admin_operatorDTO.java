package com.nadun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin_operatorDTO {
    private String operator_id;
    private String first_name;
    private String last_name;
    private String password;
}
