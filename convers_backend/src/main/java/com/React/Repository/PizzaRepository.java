package com.React.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.React.Entity.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

}
