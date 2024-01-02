package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book,Integer>{

	@Query(value = "select * from tbl_book where title = :title", nativeQuery = true)
	List<Book> sql1(@Param("title") String title);
	
	@Query(value = "select * from tbl_book where price >= 30000 and publisher = '남가람북스'", nativeQuery = true)
	List<Book>sql2();
	
	@Query(value = " select * from tbl_book where publisher in( '한빛출판사', '이지스퍼블리싱')", nativeQuery = true)
	List<Book> sql3();
	

	
	
	
}
