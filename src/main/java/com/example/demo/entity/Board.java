package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//엔티티의 변화를 감지하는 
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_board")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	//엔티티를 구성할때 무조건 pk를 지정해주어야함
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo;
	
	@Column(length = 30, nullable = false)
	String title;
	
	@Column(length = 200)
	String content;
	
	@CreatedDate//인스턴스가 생성되는 겂을 감지하여 날짜를 저장
	@DateTimeFormat(pattern = "yyyyy-MM-dd HH:mm:ss")
	LocalDateTime createdDate;
	
	@LastModifiedDate//인스턴스가 수정되는 것을 감지하여 날짜를 저장
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate;
	
	
}
