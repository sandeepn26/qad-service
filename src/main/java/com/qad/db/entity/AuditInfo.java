package com.qad.db.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public class AuditInfo {

	@Column(name = "CREATED_BY")
	@CreatedBy
	private Long createdBy;
	
	@Column(name = "MODIFIED_BY")
	@LastModifiedBy
	private Long modifiedBy;
	
	@Column(name = "CREATED_TIME")
	@CreatedDate
	private LocalDateTime  createdTime;

	@Column(name = "MODIFIED_TIME")
	@LastModifiedDate
	private LocalDateTime  modifiedTime;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

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
