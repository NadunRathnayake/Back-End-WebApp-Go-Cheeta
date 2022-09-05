package com.nadun.spring.controller;

import com.nadun.spring.dto.DriverDTO;
import com.nadun.spring.dto.VehicleDTO;
import com.nadun.spring.dto.Vehicle_CategoryDTO;
import com.nadun.spring.service.Vehicle_CategoryService;
import com.nadun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class Vehicle_CategoryController {

    @Autowired
    Vehicle_CategoryService vehicle_categoryService;

    @PostMapping("/add/vehicle-category")
    public ResponseEntity<?> addVehicleCategory(@RequestBody Vehicle_CategoryDTO dto) {
        vehicle_categoryService.addVehicleCategory(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/view/category-list")
    public ResponseEntity<?> allCategoryList() {
        List<Vehicle_CategoryDTO> allCategoryList = vehicle_categoryService.getallCategoryList();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allCategoryList), HttpStatus.OK);
    }

    @DeleteMapping( "/delete/category/{category_id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String category_id) {
        vehicle_categoryService.deleteCategory(category_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @PutMapping("/update/category")
    public ResponseEntity<?> updateCategorydetail(@RequestBody Vehicle_CategoryDTO dto) {
        vehicle_categoryService.updateCategorydetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/search/category/{category_id}")
    public ResponseEntity<?> searchCategory(@PathVariable String category_id) {
        Vehicle_CategoryDTO categoryDetailsDTO = vehicle_categoryService.searchCategories(category_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", categoryDetailsDTO), HttpStatus.OK);
    }

}
