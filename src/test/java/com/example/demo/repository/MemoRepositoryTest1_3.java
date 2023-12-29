package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_3 {
	
	@Autowired
	MemoRepository repo;
	
	@Test
	public void 번호가10와20사이인_메모검색() {
		List<Memo> list = repo.findByNoBetween(30, 50);
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가10보다작은데이터검색() {
		List<Memo> list = repo.findByNoLessThan(30);
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 텍스트가null이아닌_메모검색() {
		List<Memo> list = repo.findByTextIsNotNull();
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 메모의번호를역정렬() {
		List<Memo> list = repo.findAllByOrderByNoDesc();
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가5보다자근_메모삭제() {
		repo.deleteMemoByNoLessThan(5);
		//@Transactional이 없다면 에러남
		//deleteby는 기본적으로 롤백처리가 되어 결과가 반영되지 않음
		
	}
	
	
	
}
