package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositorySql {
	
	@Autowired
	MemoRepository repo;
	
	@Test
	public void 번호가13보다작은_메모검색() {
		List<Memo> list = repo.get1(13);
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 텍스트가null이아닌_메모검색() {
		List<Memo> list = repo.get2();
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가10에서20사이인_메모검색() {
		List<Memo> list = repo.get3(10, 20);
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void no역정렬_메모검색() {
		List<Memo> list = repo.get4();
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	

}
