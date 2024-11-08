package com.jobqDemo.entity;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="jobqq")
public class JobQueue {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private UUID reqid;
	    
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
	    private LocalDateTime addedat;

	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private LocalDateTime startedat;

	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private LocalDateTime endedat;

	    private Long duration;

	    @Column(columnDefinition = "TEXT")
	    private String params;

	    @Column(columnDefinition = "TEXT")
	    private String response;

	    private String status;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public UUID getReqid() {
			return reqid;
		}

		public void setReqid(UUID reqid) {
			this.reqid = reqid;
		}

		public LocalDateTime getAddedat() {
			return addedat;
		}

		public void setAddedat(LocalDateTime addedat) {
			this.addedat = addedat;
		}

		public LocalDateTime getStartedat() {
			return startedat;
		}

		public void setStartedat(LocalDateTime startedat) {
			this.startedat = startedat;
		}

		public LocalDateTime getEndedat() {
			return endedat;
		}

		public void setEndedat(LocalDateTime endedat) {
			this.endedat = endedat;
		}

		public Long getDuration() {
			return duration;
		}

		public void setDuration(Long duration) {
			this.duration = duration;
		}

		public String getParams() {
			return params;
		}

		public void setParams(String params) {
			this.params = params;
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	
}
