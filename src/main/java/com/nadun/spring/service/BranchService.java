package com.nadun.spring.service;

import com.nadun.spring.dto.BranchDTO;


public interface BranchService {

    void addBranch(BranchDTO dto);
    BranchDTO searchBranchDet(String branch_name);
}
