package com.nadun.spring.service;

import com.nadun.spring.dto.BookingDTO;
import com.nadun.spring.dto.BranchDTO;
import com.nadun.spring.dto.DriverDTO;


import java.util.List;

public interface BookingService {
    void addBooking (BookingDTO dto);
    List<BookingDTO>getallbookDetails();
    void updateBookingDetail(BookingDTO dto);
    BookingDTO searchBookingDet(String booking_id);
    void deleteBooking(String booking_id);

}
