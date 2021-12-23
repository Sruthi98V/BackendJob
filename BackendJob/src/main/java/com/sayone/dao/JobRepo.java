package com.sayone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sayone.model.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

	List<Job> findAllByStatus(String status);

}
