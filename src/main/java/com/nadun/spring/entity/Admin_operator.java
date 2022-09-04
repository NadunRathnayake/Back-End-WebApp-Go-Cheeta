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

public class Admin_operator {
    @Id
    private String operator_id;
    private String first_name;
    private String last_name;
    private String password;
}
