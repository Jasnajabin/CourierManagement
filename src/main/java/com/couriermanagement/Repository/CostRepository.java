package com.couriermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.couriermanagement.entity.Cost;
import java.util.List;


@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {
	Cost findTopByOrderByIdDesc();

	
}
