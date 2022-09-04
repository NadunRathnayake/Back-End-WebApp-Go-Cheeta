package com.nadun.spring.service.impl;
import com.nadun.spring.dto.VehicleDTO;
import com.nadun.spring.entity.Vehicle;
import com.nadun.spring.repo.VehicleRepo;
import com.nadun.spring.service.VehicleService;
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

public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addVehicle(VehicleDTO dto) {
        if (!repo.existsById(dto.getVehicle_no())) {
            Vehicle c = mapper.map(dto, Vehicle.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Vehicle already exist..!");
        }
    }

    public VehicleDTO searchVehicleDetail(String vehicle_no) {
        Optional<Vehicle> vehicleDetails = repo.findById(vehicle_no);
        if (vehicleDetails.isPresent()) {
            return mapper.map(vehicleDetails.get(), VehicleDTO.class);
        } else {
            throw new RuntimeException("No Vehicle for id: " + vehicle_no);
        }
    }

    @Override
    public void updateVehicledetails(VehicleDTO dto) {
        if (repo.existsById(dto.getVehicle_no())) {
            Vehicle c = mapper.map(dto, Vehicle.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    @Override
    public void deleteVehicle(String vehicle_no) {
        if (repo.existsById(vehicle_no)) {
            repo.deleteById(vehicle_no);
        } else {
            throw new RuntimeException("No Vehicle for delete ID: " + vehicle_no);
        }

    }

    @Override
    public List<VehicleDTO> getallVehicleList() {
        List<Vehicle> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }
}
