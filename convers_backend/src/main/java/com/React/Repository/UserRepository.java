package com.React.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.React.Entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User where name=:n")
	List<User> findUserByName(@Param("n") String name);
	
	@Query("from User where email=:e")
	List<User> findUserByEmail(@Param("e") String email);
	
	@Query("from User where password=:e")
	List<User> findUserByPassword(@Param("e") String ema);
}
