package com.nadun.spring.controller;


import com.nadun.spring.dto.BookingDTO;
import com.nadun.spring.dto.BranchDTO;
import com.nadun.spring.dto.CustomerDTO;
import com.nadun.spring.dto.DriverDTO;
import com.nadun.spring.entity.Booking;
import com.nadun.spring.service.BookingService;
import com.nadun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class BookingContoller {

    @Autowired
    BookingService bookingService;

    @PostMapping("/booking/save")
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO dto) {
        bookingService.addBooking(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/view-booking")
    public ResponseEntity<?> allbookDetails() {
        List<BookingDTO> allBookingDetails = bookingService.getallbookDetails();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allBookingDetails), HttpStatus.OK);
    }

    @PutMapping("/update/booking")
    public ResponseEntity<?> updateBookingDetail(@RequestBody BookingDTO dto) {
        bookingService.updateBookingDetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/booking/{cust_id}")
    public ResponseEntity<?> searchBooking(@PathVariable String cust_id) {
        BookingDTO bookingDetailDTO = bookingService.searchBookingDet(cust_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", bookingDetailDTO), HttpStatus.OK);
    }

}
