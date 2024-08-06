package com.couriermanagement.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.couriermanagement.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}
