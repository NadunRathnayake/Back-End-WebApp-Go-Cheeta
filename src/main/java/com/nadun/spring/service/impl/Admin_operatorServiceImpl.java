package com.nadun.spring.service.impl;

import com.nadun.spring.dto.Admin_operatorDTO;
import com.nadun.spring.dto.BranchDTO;
import com.nadun.spring.entity.Admin_operator;
import com.nadun.spring.entity.Branch;
import com.nadun.spring.repo.Admin_operatorRepo;
import com.nadun.spring.service.Admin_operatorService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional

public class Admin_operatorServiceImpl implements Admin_operatorService {

    @Autowired
    private Admin_operatorRepo repo;

    @Autowired
    private ModelMapper mapper;

    public void addAdmin(Admin_operatorDTO dto) {
        if (!repo.existsById(dto.getOperator_id())) {
            Admin_operator c = mapper.map(dto, Admin_operator.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Admin Already exist..!");
        }
    }
}
