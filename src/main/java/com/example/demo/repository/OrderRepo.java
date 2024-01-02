package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepo  extends JpaRepository<Order, Integer>{

	@Query(value = "select * from tbl_order where ship_address like :str%",nativeQuery = true)
	List<Order> sql1(@Param("str") String str);
	
	@Query(value = "select * from tbl_order where date = :date",nativeQuery = true)
	List<Order> sql2(@Param("date") LocalDate date);
	
}
