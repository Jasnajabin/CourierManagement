package com.couriermanagement.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.couriermanagement.entity.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
	  @Query("SELECT c FROM Courier c WHERE " +
	           "(:trackingNo IS NULL OR c.trackingNo LIKE %:trackingNo%) AND " +
	           "(:updatestatus IS NULL OR c.updatestatus LIKE %:updatestatus%)")
	    List<Courier> searchByTrackingNumberAndStatus(
	            @Param("trackingNo") String trackingNo,
	            @Param("updatestatus") String updatestatus);
}
