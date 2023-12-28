package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Gift;

public interface GiftRepo extends JpaRepository<Gift, Integer>{

}
