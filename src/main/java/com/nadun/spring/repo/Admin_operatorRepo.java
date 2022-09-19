package com.nadun.spring.repo;

import com.nadun.spring.entity.Admin_operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin_operatorRepo extends JpaRepository<Admin_operator, String> {
 boolean existsByOperatorId(String username);
//
    Admin_operator findByOperatorId(String username);
}
