package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

//메모 리포지토리를 사용하여
//메모테이블의 데이터를 등록, 조회, 수정, 삭제한다.

@SpringBootTest
public class MemoRepositoryTest1_1 {

	@Autowired
	MemoRepository memoRepository;

	@Test
	public void 리포지토리객체를가져왔는지확인() {

		System.out.println("memoRepository = " + memoRepository);
	}

	@Test
	public void 데이터등록() {
		Memo memo = Memo
					.builder()
					.text("새글입니다")
					.build();

		memoRepository.save(memo);//하나만 입력받고 한건만 저장
	}
	
	@Test
	public void 데이터일괄등록() {
		List<Memo> list = new ArrayList<>();
		
		Memo memo1 = new Memo(0, "새글입니다.");
		Memo memo2 = new Memo(0, null);
		
		list.add(memo1);
		list.add(memo2);
		
		memoRepository.saveAll(list); //자료구조를 받아서 한번에 저장
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Memo> result = memoRepository.findById(4); //no 값을 기준으로 no가 1인 값을 가져오는것
		
		if(result.isPresent()) {//결과값이 있는지 확인
			Memo memo = result.get();//값 꺼내기
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Memo> list = memoRepository.findAll();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터수정() {
		Memo memo = new Memo(10,"글이수정되었습니다");
		
		//1번이 존재하는 확인하고 update 실행
		//존재하지 않다면 insert 됨
		memoRepository.save(memo);
	}
	
	@Test
	public void 데이터삭제() {
		//1번이 존재하는지 확인하고 delete 실행
		memoRepository.deleteById(1); //단건 삭제(memo 엔티티 안에 pk가 1인 데이터 삭제)
	}
	
	@Test
	public void 데이터전체삭제() {
		memoRepository.deleteAll();
	}
	

}
