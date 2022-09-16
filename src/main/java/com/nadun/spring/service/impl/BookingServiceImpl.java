package com.nadun.spring.service.impl;


import com.nadun.spring.dto.*;
import com.nadun.spring.entity.*;
import com.nadun.spring.repo.BookingRepo;
import com.nadun.spring.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional

public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo repo;

    @Autowired
    private ModelMapper mapper;

    public void addBooking(BookingDTO dto) {
        if (!repo.existsById(dto.getCust_id())) {
            Booking c = mapper.map(dto, Booking.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Booking Already exist..!");
        }
    }

    @Override
    public List<BookingDTO> getallbookDetails() {
        List<Booking> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<BookingDTO>>() {
        }.getType());
    }


    @Override
    public void updateBookingDetail(BookingDTO dto) {
        if (repo.existsById(dto.getCust_id())) {
            Booking c = mapper.map(dto, Booking.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Booking Update..!");
        }
    }

    @Override
    public BookingDTO searchBookingDet(String cust_id) {
        Optional<Booking> bookingDetails = repo.findById(cust_id);
        if (bookingDetails.isPresent()) {
            return mapper.map(bookingDetails.get(), BookingDTO.class);
        } else {
            throw new RuntimeException("No Branch for id: " + cust_id);
        }
    }

}
