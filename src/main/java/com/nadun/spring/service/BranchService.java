package com.nadun.spring.service;

import com.nadun.spring.dto.BranchDTO;

import java.util.List;


public interface BranchService {

    void addBranch(BranchDTO dto);
    BranchDTO searchBranchDet(String branch_code);
    void updateBranchDetail(BranchDTO dto);
    void deleteBranch(String branch_code);
    List<BranchDTO> getallBranchList();

}
