package com.nadun.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
    @Id
    private String nic;
    private String password;
}
