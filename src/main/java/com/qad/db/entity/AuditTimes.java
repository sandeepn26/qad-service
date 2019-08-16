package com.qad.db.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public class AuditTimes {

	@Column(name = "CREATED_TIME", nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime  createdTime;

	@Column(name = "MODIFIED_TIME", nullable = false)
	@LastModifiedDate
	private LocalDateTime  modifiedTime;

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
}
