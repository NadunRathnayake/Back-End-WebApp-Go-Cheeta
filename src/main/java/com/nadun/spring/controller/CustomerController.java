package com.nadun.spring.controller;

import com.nadun.spring.dto.CustomerDTO;
import com.nadun.spring.service.CustomerService;
import com.nadun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO dto) {
        customerService.addCustomer(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping(path = "{nic}")
    public ResponseEntity<?> searchCustomer(@PathVariable String nic) {
        CustomerDTO custDetailDTO = customerService.searchCustDetail(nic);
        return new ResponseEntity<>(new StandradResponse(200, "Success", custDetailDTO), HttpStatus.OK);
    }

    @GetMapping("/view-cust")
    public ResponseEntity<?> allCustDetails() {
        List<CustomerDTO> allCustomerDetails = customerService.getAllCustDet();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allCustomerDetails), HttpStatus.OK);
    }

    @PutMapping("/update-cust")
    public ResponseEntity<?> updateCustdetail(@RequestBody CustomerDTO dto) {
        customerService.updateCustdetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @DeleteMapping( "{nic}")
    public ResponseEntity<?> deleteCustomerDetail(@PathVariable String nic) {
        customerService.deleteCustomerDetail(nic);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }


}
