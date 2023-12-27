package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

//엔티티 클래스는 table과 매핑되기때문에 반드시 pk를 가지고 있어야함

@Entity
@Table(name = "tb1_memo") //실제 db의 table 이름

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {
	
	@Id//pk표시
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increament
	int no;
	
	
	@Column(length = 200, nullable = true)
	String text;
	
}
