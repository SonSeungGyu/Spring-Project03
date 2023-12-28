package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class Quiz3 {

	@Autowired
	OrderRepo repo;
	
	@Test
	public void 데이터추가() {
		List<Order> list = new ArrayList<>();
		LocalDate localDate1 = LocalDate.of(2023, 07, 01);
		LocalDate localDate2 = LocalDate.of(2023, 05, 01);
		LocalDate localDate3 = LocalDate.of(2023, 04, 01);
		
		Order order1 = new Order(0, "둘리",localDate1,"인천 구월동" );
		Order order2 = new Order(0, "또치",localDate2,"인천 연수동" );
		Order order3 = new Order(0, "도우너",localDate3,"부산 동래동" );
		
		list.add(order1);
		list.add(order2);
		list.add(order3);
		
		repo.saveAll(list);
	}
	
	@Test
	public void 데이터조회() {
		List<Order> list = repo.findAll();
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Order> result = repo.findById(2);
		if(result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터삭제() {
		repo.deleteById(3);
	}
}
