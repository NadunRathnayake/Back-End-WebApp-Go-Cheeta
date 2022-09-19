package com.nadun.spring.repo;

import com.nadun.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String> {


    @Query(value = "SELECT EXISTS(SELECT * FROM driver d WHERE d.driver_id=?1)", nativeQuery = true)
    BigInteger existsByDriverId(String username);

    @Query(value = "SELECT * FROM driver d WHERE d.driver_id=?1", nativeQuery = true)
    Driver findByDriverId(String username);
}
