package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest1 {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	void 리포지토리객체가져왔는지() {
		System.out.println(repository);
	}
	
	
	@Test
	public void 데이터등록() {
		Board board1 = new Board(0,"1번글","내용입니다",null,null);
		repository.save(board1);//등록일과 수정일이 현재시간으로 자동 등록됨
		
		Board board2 = Board
						.builder()
						.title("2번글")
						.content("내용입니다")
						.build();//날짜 생략
		repository.save(board2);
		
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Board> result = repository.findById(5);
		if(result.isPresent()) {//결과값이 있는지 확인
			Board board = result.get();
			System.out.println(board);
		}else {
			System.out.println("잘못된 pk값입니다.");
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Board> list = repository.findAll();
		
		for(Board board : list ) {
			System.out.println(board);
		}
	}
	
	@Test
	public void 데이터수정() {
		//1번 게시물 조회
		Optional<Board> result = repository.findById(1);
		Board board = result.get();
		
		//일부 값 변경
		board.setContent("내용이 수정되었습니다");
		
		//1번이 존재하는지 확인하고 update 실행
		//1번이 존재하지 않다면 insert 실행
		repository.save(board);
	}
	
	@Test
	public void 데이터삭제() {
		//pk가 1인 데이터 삭제
		repository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		repository.deleteAll();
	}
	
	
	
	
	
}
