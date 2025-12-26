package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TasksEntity;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Integer> {

}
