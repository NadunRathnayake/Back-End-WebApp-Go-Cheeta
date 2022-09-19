package com.nadun.spring.service.impl;

import com.nadun.spring.dto.CustomerDTO;
import com.nadun.spring.dto.LoginDTO;
import com.nadun.spring.entity.Admin_operator;
import com.nadun.spring.entity.Customer;
import com.nadun.spring.entity.Driver;
import com.nadun.spring.repo.Admin_operatorRepo;
import com.nadun.spring.repo.CustomerRepo;
import com.nadun.spring.repo.DriverRepo;
import com.nadun.spring.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private Admin_operatorRepo admin_operatorRepo;

    @Autowired
    private DriverRepo driverRepo;

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

    @Override
    public boolean login(String username, String password, String usertype) {

        BigInteger ss = driverRepo.existsByDriverId(username);


        if(repo.existsByNic(username) && usertype.equals("CUSTOMER")){
            Customer customer = repo.findByNic(username);
            if(customer.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }else if(driverRepo.existsByDriverId(username).equals(new BigInteger("1")) && usertype.equals("DRIVER")){
            Driver driver = driverRepo.findByDriverId(username);
            if(driver.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }else if(admin_operatorRepo.existsByOperatorId(username) && usertype.equals("ADMIN")){
            Admin_operator admin_operator = admin_operatorRepo.findByOperatorId(username);
            if(admin_operator.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

//    @Override
//    public void checkCustomerLogin(CustomerDTO dto) {
//        if (repo.existsById(dto.getNic())) {
//          if ()
//            System.out.println("test done");
//        } else {
//            System.out.println("fail test");
//        }
//    }
//}
 //select password from customer where nic = dto.getNic