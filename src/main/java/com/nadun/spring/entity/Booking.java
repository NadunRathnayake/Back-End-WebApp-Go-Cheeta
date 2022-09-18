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
public class Booking {
    @Id
    private String booking_id;
    private String cust_id;
    private String driver_id;
    private String customer_name;
    private String date;
    private String time;
    private String pickup;
    private String destination;
    private String phone_no;
    private String price;
}
