package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepo extends JpaRepository<Gift, Integer>{

	@Query(value = "select * from tbl_gift where price >= :price", nativeQuery = true)
	List<Gift> sql1(@Param("price") int price);
	@Query(value = "select * from tbl_gift where name like '%세트'", nativeQuery = true)
	List<Gift> sql2();
	@Query(value = "select * from tbl_gift where price <= 40000 and type = '생활용품'", nativeQuery = true)
	List<Gift> sql3();
	
	@Query("select g from Gift g where g.price >= :price")
	List<Gift> get1(@Param("price") int price);
	@Query("select g from Gift g where g.name like '%세트'")
	List<Gift> get2();
	@Query("select g from Gift g where g.price <= :price and g.type = :type")
	List<Gift> get3(@Param("price") int price, @Param("type")String type);
	
}
