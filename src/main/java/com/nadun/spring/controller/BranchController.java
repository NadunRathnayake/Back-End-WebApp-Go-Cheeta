package com.nadun.spring.controller;

import com.nadun.spring.dto.BranchDTO;
import com.nadun.spring.dto.CustomerDTO;
import com.nadun.spring.service.BranchService;
import com.nadun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class BranchController {
    @Autowired
    BranchService branchService;

    @PostMapping("/branch/save")
    public ResponseEntity<?> addBranch(@RequestBody BranchDTO dto) {
        branchService.addBranch(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/branch/{branch_code}")
    public ResponseEntity<?> searchCustomer(@PathVariable String branch_code) {
        BranchDTO branchDetailDTO = branchService.searchBranchDet(branch_code);
        return new ResponseEntity<>(new StandradResponse(200, "Success", branchDetailDTO), HttpStatus.OK);
    }


}
