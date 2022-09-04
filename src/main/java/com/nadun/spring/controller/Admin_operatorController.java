package com.nadun.spring.controller;

import com.nadun.spring.dto.Admin_operatorDTO;
import com.nadun.spring.service.Admin_operatorService;
import com.nadun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class Admin_operatorController {
    @Autowired
    Admin_operatorService admin_operatorService;

    @PostMapping("/admin/save")
    public ResponseEntity<?> addAdmin(@RequestBody Admin_operatorDTO dto) {
        admin_operatorService.addAdmin(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
