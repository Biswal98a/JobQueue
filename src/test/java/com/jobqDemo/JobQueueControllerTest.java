package com.jobqDemo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobqDemo.controller.JobQueueController;
import com.jobqDemo.entity.JobQueue;
import com.jobqDemo.service.JobQueueService;

@ExtendWith(MockitoExtension.class)
public class JobQueueControllerTest {
	    @Autowired
        private MockMvc mockMvc;
	    @Mock
	    private JobQueueService jobQueueService;

	    @InjectMocks
	    private JobQueueController jobQueueController;

	    private JobQueue jobQueue;
	    private UUID reqid;
	   
	    @BeforeEach
	    void setUp() {
	        reqid = UUID.randomUUID();
	        jobQueue = new JobQueue();
	        jobQueue.setReqid(reqid);
	        jobQueue.setStatus("pending");
	        jobQueue.setParams("{\"key\":\"value\"}");
//	        jobQueue.setAddedat(LocalDateTime.now());
//	        jobQueue.setStartedat(LocalDateTime.now());

	        // Initialize MockMvc
	        mockMvc = MockMvcBuilders.standaloneSetup(jobQueueController).build();
	    }
	    
	    @Test
	    void testCreateJob() throws Exception {
	        // Arrange: Mock the service to return a created job
	        when(jobQueueService.createJob(any(JobQueue.class))).thenReturn(jobQueue);

	        // Act & Assert: Perform the POST request and verify the response
	        mockMvc.perform(post("/api/jobqueue/create")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(jobQueue))) // Convert jobQueue to JSON
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.reqid").value(reqid.toString()))
	                .andExpect(jsonPath("$.status").value("pending"))
	                .andExpect(jsonPath("$.params").value("{\"key\":\"value\"}"));
//	                .andExpect(jsonPath("$.addedat").exists())  // Check for addedat
//	                .andExpect(jsonPath("$.startedat").exists()) // Check for startedat
//	                .andExpect(jsonPath("$.endedat").exists());  // Check for endedat

	        verify(jobQueueService, times(1)).createJob(any(JobQueue.class)); // Verify service call
	    }

		private String asJsonString(JobQueue jobQueue) {
			try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.writeValueAsString(jobQueue);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
		}

	
}
