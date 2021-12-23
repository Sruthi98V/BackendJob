package com.sayone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayone.exceptions.GlobalExceptions;
import com.sayone.model.Job;
import com.sayone.service.JobService;

@RestController
@RequestMapping("/backendjob")
@PropertySource("classpath:message.properties")
public class JobController {

	@Autowired
	JobService jobService;
	
	@GetMapping(value = "/getjobs/status/{status}")
	public List<Job> listOfJobs(@PathVariable("status") String status) throws GlobalExceptions{	
		return jobService.getJobsByStatus(status);	
	}
	
	@GetMapping(value = "/getjobs/id/{jobId}")
	@ResponseBody
	public Optional<Job> listOfJobs(@PathVariable("jobId") Integer id) throws GlobalExceptions{
		return jobService.getJobsById(id);
	}
	
	@PutMapping(value="/change/{jobId}")
	public String changeStatus(@PathVariable("jobId") Integer id, @RequestBody Job job ){
		return jobService.changeStatus(id,job);
	}
	
	@DeleteMapping(value="/delete-job")
	public String deleteJobs(@RequestParam Integer[] ids) {
		return jobService.deleteJobs(ids);
	}
}
