package com.couriermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.couriermanagement.entity.Staff;
import java.util.List;


@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
 Staff  findByEmail(String email);
}
