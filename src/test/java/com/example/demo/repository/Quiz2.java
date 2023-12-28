package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class Quiz2 {
	
	@Autowired
	GiftRepo repo;
	
	@Test
	public void 데이터추가() {
		List<Gift> list = new ArrayList<>();
		
		Gift gift1 = new Gift(0, "참치세트",10000,"식품");
		Gift gift2 = new Gift(0, "햄세트",20000,"식품");
		Gift gift3 = new Gift(0, "샴푸세트",30000,"생활용품");
		Gift gift4 = new Gift(0, "세차용품",40000,"생활용품");
		Gift gift5 = new Gift(0, "주방용품",50000,"생활용품");
		Gift gift6 = new Gift(0, "노트북",50000,"가전제품");
		Gift gift7 = new Gift(0, "벽걸이TV",70000,"가전제품");
		
		list.add(gift1);
		list.add(gift2);
		list.add(gift3);
		list.add(gift4);
		list.add(gift5);
		list.add(gift6);
		list.add(gift7);
		
		repo.saveAll(list);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Gift> result = repo.findById(4);
		if(result.isPresent()) {
			
			System.out.println(result.get());
//			Gift gift = result.get();
//			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Gift> list = repo.findAll();
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Gift> result = repo.findById(1);
		Gift gift = result.get();
		gift.setName("김세트");
		
		repo.save(gift);
	}
	
	@Test
	public void 데이터삭제() {
		repo.deleteById(3);
	}
	
	@Test
	public void 데이터전체삭제() {
		repo.deleteAll();
	}

}
