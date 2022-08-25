package com.example.housemaid.repository;

import com.example.housemaid.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {


    List<Task> findByUserId(Integer id);
}