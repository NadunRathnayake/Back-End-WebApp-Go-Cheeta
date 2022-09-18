package com.nadun.spring.service.impl;


import com.nadun.spring.dto.CustomerDTO;
import com.nadun.spring.dto.DriverDTO;
import com.nadun.spring.entity.Customer;
import com.nadun.spring.entity.Driver;
import com.nadun.spring.repo.DriverRepo;
import com.nadun.spring.service.DriverService;
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


public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriverId())) {
            Driver c = mapper.map(dto, Driver.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Driver is already Registered..!");
        }
    }

    public DriverDTO searchDriverDetail(String driverId) {
        Optional<Driver> driverDetail = repo.findById(driverId);
        if (driverDetail.isPresent()) {
            return mapper.map(driverDetail.get(), DriverDTO.class);
        } else {
            throw new RuntimeException("No Driver for id: " + driverId);
        }
    }

    @Override
    public void updateDriverdetail(DriverDTO dto) {
        if (repo.existsById(dto.getDriverId())) {
            Driver c = mapper.map(dto, Driver.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    @Override
    public void deleteDriver(String driver_id) {
        if (repo.existsById(driver_id)) {
            repo.deleteById(driver_id);
        } else {
            throw new RuntimeException("No Driver for delete ID: " + driver_id);
        }

    }

    @Override
    public List<DriverDTO> getallDriverList() {
        List<Driver> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }
}
