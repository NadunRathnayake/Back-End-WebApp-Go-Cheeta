package com.nadun.spring.service.impl;

import com.nadun.spring.dto.VehicleDTO;
import com.nadun.spring.dto.Vehicle_CategoryDTO;
import com.nadun.spring.entity.Vehicle;
import com.nadun.spring.entity.Vehicle_Category;
import com.nadun.spring.repo.Vehicle_CategoryRepo;
import com.nadun.spring.service.Vehicle_CategoryService;
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

public class Vehicle_CategoryServiceImpl implements Vehicle_CategoryService {

    @Autowired
    private Vehicle_CategoryRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addVehicleCategory(Vehicle_CategoryDTO dto) {
        if (!repo.existsById(dto.getCategory_id())) {
            Vehicle_Category c = mapper.map(dto, Vehicle_Category.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Vehicle category already exist..!");
        }
    }

    @Override
    public List<Vehicle_CategoryDTO> getallCategoryList() {
        List<Vehicle_Category> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<Vehicle_CategoryDTO>>() {
        }.getType());
    }


    @Override
    public void deleteCategory(String category_id) {
        if (repo.existsById(category_id)) {
            repo.deleteById(category_id);
        } else {
            throw new RuntimeException("No Vehicle Category for delete ID: " + category_id);
        }
    }

    @Override
    public void updateCategorydetail(Vehicle_CategoryDTO dto) {
        if (repo.existsById(dto.getCategory_id())) {
            Vehicle_Category c = mapper.map(dto, Vehicle_Category.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    public Vehicle_CategoryDTO searchCategories(String category_id) {
        Optional<Vehicle_Category> vehicleCategories = repo.findById(category_id);
        if (vehicleCategories.isPresent()) {
            return mapper.map(vehicleCategories.get(), Vehicle_CategoryDTO.class);
        } else {
            throw new RuntimeException("No Vehicle Category for id: " + category_id);
        }
    }
}
