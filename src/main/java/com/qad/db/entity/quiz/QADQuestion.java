package com.qad.db.entity.quiz;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qad.db.entity.AuditTimes;

@Entity
@Table(name = "QAD_QUESTION")
public class QADQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID", updatable = false)
	private Long questionId;
	
	@Column(name = "QUESTION")
	private String question;
	
	@Column(name = "QUESTION_IMAGE")
	private String questionImage;
	
	@Column(name = "CREATE_MEMBER")
	private Long createMember;
	
	@Embedded
	private AuditTimes auditTimes;
}
