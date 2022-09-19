package com.nadun.spring.service;


import com.nadun.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void  addDriver(DriverDTO dto);
    DriverDTO searchDriverDetail (String driver_id);
    void updateDriverdetail(DriverDTO dto);
    void deleteDriver(String driverId);
    List<DriverDTO> getallDriverList();

}
