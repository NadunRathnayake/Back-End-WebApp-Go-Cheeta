package com.nadun.spring.service.impl;

import com.nadun.spring.dto.BranchDTO;
import com.nadun.spring.entity.Branch;
import com.nadun.spring.repo.BranchRepo;
import com.nadun.spring.service.BranchService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Slf4j
@Transactional
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepo repo;

    @Autowired
    private ModelMapper mapper;
    public void addBranch(BranchDTO dto) {
        if (!repo.existsById(dto.getBranch_code())) {
            Branch c = mapper.map(dto, Branch.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Branch Already exist..!");
        }
    }
}
