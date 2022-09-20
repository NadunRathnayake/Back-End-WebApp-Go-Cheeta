package com.nadun.spring.controller;


import com.nadun.spring.dto.BookingDTO;
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

    @GetMapping(path = "/booking/{booking_id}")
    public ResponseEntity<?> searchBooking(@PathVariable String booking_id) {
        BookingDTO bookingDetailDTO = bookingService.searchBookingDet(booking_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", bookingDetailDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/booking/driver/{driver_id}")
    public ResponseEntity<?> searchBookingDriver(@PathVariable String driver_id) {
        BookingDTO bookingDetailDTO = bookingService.searchBookingDetDR(driver_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", bookingDetailDTO), HttpStatus.OK);
    }


    @DeleteMapping( "/delete/booking/{booking_id}")
    public ResponseEntity<?> deleteBooking(@PathVariable String booking_id) {
        bookingService.deleteBooking(booking_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }

}
