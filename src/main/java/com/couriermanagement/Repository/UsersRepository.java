package com.couriermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.couriermanagement.entity.Users;
import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	 Users findByEmail(String email);
}
