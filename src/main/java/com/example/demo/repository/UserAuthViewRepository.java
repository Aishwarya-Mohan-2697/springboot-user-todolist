package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserAuthViewEntity;
import com.example.demo.entity.UserEntity;


@Repository
public interface UserAuthViewRepository extends JpaRepository<UserAuthViewEntity, Integer> {
	UserAuthViewEntity findByUserName(String userName);
}
