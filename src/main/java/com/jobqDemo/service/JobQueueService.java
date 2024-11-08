package com.jobqDemo.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobqDemo.entity.JobQueue;
import com.jobqDemo.repository.JobQueueRepository;

@Service
public class JobQueueService {
	@Autowired
    private JobQueueRepository jobQueueRepository;

    public JobQueue createJob(JobQueue jobQueue) {
        jobQueue.setAddedat(LocalDateTime.now());
        jobQueue.setStartedat(LocalDateTime.now());
        jobQueue.setStatus("pending");
        jobQueue.setReqid(UUID.randomUUID()); // Generate a unique request ID
        return jobQueueRepository.save(jobQueue);
    }
    public JobQueue getJobByReqid(UUID reqid) {
        return jobQueueRepository.findByReqid(reqid);
    }
	public void updateJob(JobQueue jobQueue) {
		jobQueue.setEndedat(LocalDateTime.now());
        jobQueue.setStatus("done"); // Change the status based on your logic
        jobQueueRepository.save(jobQueue);
	}

}
