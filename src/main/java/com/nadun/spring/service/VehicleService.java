package com.nadun.spring.service;

import com.nadun.spring.dto.VehicleDTO;
import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleDTO dto);
    VehicleDTO searchVehicleDetail (String vehicle_no);
    void updateVehicledetails(VehicleDTO dto);
    void deleteVehicle(String vehicle_no);
    List<VehicleDTO> getallVehicleList();

}
