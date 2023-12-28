package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest {
	@Autowired
	BookRepository repository;
	
	//테이블에 데이터 추가
	@Test
	public void 데이터추가() {
		List<Book> list = new ArrayList<>();
		
		Book book1 = new Book(0,20000,"한빛출판사","자바포로그래밍입문");
		Book book2 = new Book(0,25000,"남가람북스","스프링부트프로젝트");
		Book book3 = new Book(0,40000,"남가람북스","실무로끝내는JPA");
		Book book4 = new Book(0,35000,"이지스퍼블리싱","알고리즘 테스트");
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		
		repository.saveAll(list);
		
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Book> result = repository.findById(1);
		if(result.isPresent()) {
			Book book = result.get();
			System.out.println(book);
		}
	}
	//Book의 인스턴스 전체 출력
	@Test
	public void 데이터조회() {
		List<Book> list = repository.findAll();
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	//pk가 1인 데이터의 타이틀을 수정
	@Test
	public void 데이터수정() {
		Optional<Book> result = repository.findById(1);
		Book book = result.get();
		book.setTitle("C언어프로그래밍");
		
		repository.save(book);
	}
	
	//pk가 2인 데이터 삭제
	@Test
	public void 데이터삭제() {
		repository.deleteById(2);
	}
}
