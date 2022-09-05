package com.nadun.spring.repo;
import com.nadun.spring.entity.Vehicle_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vehicle_CategoryRepo extends JpaRepository<Vehicle_Category, String> {
}
