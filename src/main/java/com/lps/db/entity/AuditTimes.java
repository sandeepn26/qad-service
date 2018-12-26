package com.lps.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public class AuditTimes {

	@Column(name = "CREATE_DATE", nullable = false)
	@CreatedDate
	private Date createTime;

	@Column(name = "UPDATE_DATE", nullable = false)
	@LastModifiedDate
	private Date auditTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

}
