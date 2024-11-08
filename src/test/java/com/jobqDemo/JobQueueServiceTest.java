package com.jobqDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobqDemo.entity.JobQueue;
import com.jobqDemo.repository.JobQueueRepository;
import com.jobqDemo.service.JobQueueService;

@ExtendWith(MockitoExtension.class)
public class JobQueueServiceTest {
	@Mock
    private JobQueueRepository jobQueueRepository;
	
	@InjectMocks
    private JobQueueService jobQueueService;
	
	private JobQueue jobQueue;
    private UUID reqid;
    
    @Test
    void testCreateJob() {
        // Arrange: Mock the repository to save the job
        when(jobQueueRepository.save(any(JobQueue.class))).thenReturn(jobQueue);

        // Act: Call the service method
        JobQueue createdJob = jobQueueService.createJob(jobQueue);

        // Assert: Verify the job is saved with a unique reqid and "pending" status
        assertThat(createdJob.getReqid()).isNotNull();
        assertThat(createdJob.getStatus()).isEqualTo("pending");
        assertThat(createdJob.getStartedat()).isNotNull();
        verify(jobQueueRepository, times(1)).save(any(JobQueue.class)); // Verify save method is called
    }

}
