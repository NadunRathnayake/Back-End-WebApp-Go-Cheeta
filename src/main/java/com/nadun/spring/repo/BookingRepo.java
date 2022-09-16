package com.nadun.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nadun.spring.entity.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,String> {
}
