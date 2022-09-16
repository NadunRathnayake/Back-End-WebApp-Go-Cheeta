package com.nadun.spring.controller;

import com.nadun.spring.dto.BranchDTO;
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
    public ResponseEntity<?> searchBranch(@PathVariable String branch_code) {
        BranchDTO branchDetailDTO = branchService.searchBranchDet(branch_code);
        return new ResponseEntity<>(new StandradResponse(200, "Success", branchDetailDTO), HttpStatus.OK);
    }

    @PutMapping("/update/branch")
    public ResponseEntity<?> updateBranchDetail(@RequestBody BranchDTO dto) {
        branchService.updateBranchDetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @DeleteMapping( "/delete/branch/{branch_code}")
    public ResponseEntity<?> deleteBranch(@PathVariable String branch_code) {
        branchService.deleteBranch(branch_code);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @GetMapping("/view/branch-list")
    public ResponseEntity<?> allBranchList() {
        List<BranchDTO> allBranchList = branchService.getallBranchList();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allBranchList), HttpStatus.OK);
    }


}
