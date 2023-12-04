package com.React.Repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.React.Entity.Order;


public interface OrderRepository  extends JpaRepository<Order, Integer> {

	@Query("from Order where user_id=:i")
	List<Order> findUserByUser(@Param("i") int userid);
	
}
