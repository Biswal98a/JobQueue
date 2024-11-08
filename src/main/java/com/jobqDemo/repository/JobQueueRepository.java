package com.jobqDemo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobqDemo.entity.JobQueue;

public interface JobQueueRepository extends JpaRepository<JobQueue, Long> {

	JobQueue findByReqid(UUID reqid);

}
