package com.nadun.spring.controller;

import com.nadun.spring.dto.DriverDTO;
import com.nadun.spring.dto.VehicleDTO;
import com.nadun.spring.service.VehicleService;
import com.nadun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin


public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add/vehicle")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO dto) {
        vehicleService.addVehicle(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/vehicle/{vehicle_no}")
    public ResponseEntity<?> searchVehicle(@PathVariable String vehicle_no) {
        VehicleDTO vehicleDetailsDTO = vehicleService.searchVehicleDetail(vehicle_no);
        return new ResponseEntity<>(new StandradResponse(200, "Success", vehicleDetailsDTO), HttpStatus.OK);
    }

    @PutMapping("/update/Vehicle")
    public ResponseEntity<?> updateVehicledetails(@RequestBody VehicleDTO dto) {
        vehicleService.updateVehicledetails(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @DeleteMapping( "/delete/vehicle/{vehicle_no}")
    public ResponseEntity<?> deleteVehicle(@PathVariable String vehicle_no) {
        vehicleService.deleteVehicle(vehicle_no);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @GetMapping("/view/vehicle-list")
    public ResponseEntity<?> allVehicleList() {
        List<VehicleDTO> allVehicleList = vehicleService.getallVehicleList();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allVehicleList), HttpStatus.OK);
    }

}
