package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

//메모 엔티티 클래스를 처리하기 위한 인터페이스 만들기

@Transactional
public interface MemoRepository extends JpaRepository<Memo, Integer>{
	
	//메모의 번호가 5에서 10사이인 데이터 검색
	List<Memo> findByNoBetween(int from, int to); //범위 조건 메소드
	
	//메모의 번호가 3보다 작은 데이터 검색
	List<Memo> findByNoLessThan(int mno);
	
	//메모의 내용이 있는 데이터 검색
	List<Memo> findByTextIsNotNull();//조건
	
	//메모의 번호를 기준으로 역정렬
	List<Memo> findAllByOrderByNoDesc();//findAll은 정렬을 할 때 사용해주면 된다.
	
	//---------------위는 조회 메소드------------------------------------
	//---------------이하 삭제 메소드------------------------------------
	
	//메모의 번호가 3보다 작은 데이터 삭제
	void deleteMemoByNoLessThan(int mno);
	
	//---------------jpql 사용하기-------------------------------------
	
	//메모의 번호가 3보다 작은 데이터 검색
	//select * from tbl_memo where no < ?
	@Query("select m from Memo m where m.no < :mno")
	List<Memo> get1(@Param("mno") int mno);
	
	
	//메모의 내용이 있는 데이터 검색
	//select * from tbl_memo where text is not null
	@Query("select m from Memo m where m.text is not null")
	List<Memo> get2();
	
	
	//메모의 번호가 10에서 20 사이인 데이터 검색
	//select * from tbl_memo where no between ? and ?
	@Query("select m from Memo m where m.no between :from and :to")
	List<Memo> get3(@Param("from") int from, @Param("to") int to);
	
	
	//--------------------순수한 쿼리 사용하기---------------------------
	
	//메모의 번호를 기준으로 역정렬
	//select * from tbl_memo orderby no desc
	@Query(value = "select * from tb1_memo order by no desc", nativeQuery = true)
	List<Memo> get4();
	
}
	