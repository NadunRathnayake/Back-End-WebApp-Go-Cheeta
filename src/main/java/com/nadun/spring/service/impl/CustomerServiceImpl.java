package com.nadun.spring.service.impl;

import com.nadun.spring.dto.CustomerDTO;
import com.nadun.spring.entity.Customer;
import com.nadun.spring.repo.CustomerRepo;
import com.nadun.spring.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;
    public void addCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getNic())) {
            Customer c = mapper.map(dto, Customer.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Customer Already exist..!");
        }
    }
    @Override
    public CustomerDTO searchCustDetail(String nic) {
        Optional<Customer> customerDetail = repo.findById(nic);
        if (customerDetail.isPresent()) {
            return mapper.map(customerDetail.get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Customer for id: " + nic);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustDet() {
        List<Customer> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void updateCustdetail(CustomerDTO dto) {
        if (repo.existsById(dto.getNic())) {
            Customer c = mapper.map(dto, Customer.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    @Override
    public void deleteCustomerDetail(String nic) {
        if (repo.existsById(nic)) {
            repo.deleteById(nic);
        } else {
            throw new RuntimeException("No customer for delete ID: " + nic);
        }

    }

}
