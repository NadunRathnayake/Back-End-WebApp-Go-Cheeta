package com.nadun.spring.service;

import com.nadun.spring.dto.Vehicle_CategoryDTO;
import java.util.List;

public interface Vehicle_CategoryService {

    void addVehicleCategory(Vehicle_CategoryDTO dto);
    List<Vehicle_CategoryDTO> getallCategoryList();
    void deleteCategory (String category_id);
    void updateCategorydetail(Vehicle_CategoryDTO dto);
    Vehicle_CategoryDTO searchCategories (String category_id);

}
