package com.jobqDemo.controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobqDemo.entity.JobQueue;
import com.jobqDemo.service.JobQueueService;

@RestController
@RequestMapping("/api/jobqueue")
public class JobQueueController {
	  @Autowired
	    private JobQueueService jobQueueService;
	 
	 @PostMapping("/create")
	    public ResponseEntity<JobQueue> createJob(@RequestBody JobQueue jobQueue) {
	        JobQueue createdJob = jobQueueService.createJob(jobQueue);
	        return ResponseEntity.ok(createdJob);
	    }
	 @GetMapping("/{reqid}")
	    public ResponseEntity<JobQueue> getJob(@PathVariable UUID reqid) {
	        JobQueue jobQueue = jobQueueService.getJobByReqid(reqid);
	        if (jobQueue != null) {
	            return ResponseEntity.ok(jobQueue);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 @PutMapping("/update")
	    public ResponseEntity<JobQueue> updateJob(@RequestBody JobQueue jobQueue) {
	        jobQueueService.updateJob(jobQueue);
	        return ResponseEntity.ok(jobQueue);
	    }
	
}
