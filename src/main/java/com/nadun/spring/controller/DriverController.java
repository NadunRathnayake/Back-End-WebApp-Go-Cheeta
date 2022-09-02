package com.nadun.spring.controller;


import com.nadun.spring.dto.DriverDTO;
import com.nadun.spring.service.DriverService;
import com.nadun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/save/driver")
    public ResponseEntity<?> addDriver(@RequestBody DriverDTO dto) {
        driverService.addDriver(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/driver/{driver_id}")
    public ResponseEntity<?> searchDriver(@PathVariable String driver_id) {
        DriverDTO driverDetailDTO = driverService.searchDriverDetail(driver_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", driverDetailDTO), HttpStatus.OK);
    }

}
