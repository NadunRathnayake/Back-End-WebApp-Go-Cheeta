package com.nadun.spring.service;

import com.nadun.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
     void addCustomer(CustomerDTO dto);
     CustomerDTO searchCustDetail(String nic);
     List<CustomerDTO> getAllCustDet();
     void updateCustdetail(CustomerDTO dto);
     void deleteCustomerDetail(String nic);
}


