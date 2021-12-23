package com.sayone.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayone.dao.JobRepo;
import com.sayone.exceptions.ExceptionsEnum;
import com.sayone.exceptions.GlobalExceptions;
import com.sayone.model.Job;

@Service
public class JobService {

	@Autowired
	JobRepo jobRepo;
	
	public List<Job> getJobsByStatus(String status) throws GlobalExceptions{
		List<Job> jobs=null;
			if(status!=null && !status.isEmpty()) {
				jobs=jobRepo.findAllByStatus(status);
				if (!jobs.isEmpty()) {
					Collections.sort(jobs, (job1,job2) -> job1.getStartDate().compareTo(job2.getStartDate()));
				}
				else {
					throw new GlobalExceptions(ExceptionsEnum.JOBS_NOT_FOUND.toString());
				}
			}
		return jobs;
	}

	public Optional<Job> getJobsById(Integer id) throws GlobalExceptions {
		Optional<Job> jobs=jobRepo.findById(id);
		if (!jobs.isPresent()) {
			throw new GlobalExceptions(ExceptionsEnum.JOBS_NOT_FOUND.toString());
		}
		return jobs;
	}

	public String changeStatus(Integer id, Job job) {
		Job jobById=jobRepo.getById(id);
		if(jobById!=null) {
			jobById.setStatus(job.getStatus());
			jobRepo.save(jobById);
			return "Success";
		}
		return "Failure";
	}

	public String deleteJobs(Integer[] ids) {
		List<Integer> invalidIds=new ArrayList<Integer>();
//		boolean deleteFlag = true;
		for (Integer id : ids) {
			Optional<Job> job=jobRepo.findById(id);
			if(job.isPresent()) {
				jobRepo.deleteById(id);
			}
			else {	
				invalidIds.add(id);
//				deleteFlag=false;
			}
		}
		return invalidIds.isEmpty()?"Success":"Failed to delete jobs with these Ids: "+invalidIds;
	}
}
 