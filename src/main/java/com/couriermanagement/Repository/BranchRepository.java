package com.couriermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.couriermanagement.entity.Branch;
@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
