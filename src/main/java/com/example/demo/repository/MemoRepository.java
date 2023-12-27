package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

//메모 엔티티 클래스를 처리하기 위한 인터페이스 만들기

public interface MemoRepository extends JpaRepository<Memo, Integer>{
	
	
	
}
