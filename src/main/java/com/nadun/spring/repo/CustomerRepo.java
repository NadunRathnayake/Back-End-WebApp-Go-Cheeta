package com.nadun.spring.repo;

import com.nadun.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
    //Optional<Customer> findByNic(String nic);
    //boolean existByNic();

    boolean existsByNic(String nic);
    Customer findByNic(String nic);
}