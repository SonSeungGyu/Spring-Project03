package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class Quiz4 {
	
	@Autowired
	MemberRepo repo;

	@Test
	public void 데이터추가() {
		
		List<Member> list = new ArrayList<>();
		Member mem1 = Member.builder().userId("admin").grade("관리자").password("1234").build();
		Member mem2 = Member.builder().userId("user").grade("사용자").password("1234").build();
		list.add(mem1);
		list.add(mem2);

		repo.saveAll(list);
	}

	@Test
	public void 데이터조회() {
		List<Member> list = repo.findAll();
		for (Member mem : list) {
			System.out.println(mem);
		}
	}

	@Test
	public void 데이터수정() {
		Optional<Member> result = repo.findById("user");

		Member mem = result.get();
		mem.setGrade("손님");

		repo.save(mem);
	}
	
	@Test
	public void 데이터삭제() {
		repo.deleteById("admin");
	}
}
