package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_member")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String userId;
	
	@Column(length = 255, nullable = true)
	String grade;
	
	@Column(length = 255, nullable = true)
	String password;
	
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	LocalDate registerDate;
	
}
