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
public class QADAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANSWER_ID", updatable = false)
	private Long answerId;
	
	@Column(name = "QUESTION_ID", updatable = false)
	private Long questionId;
	
	@Column(name = "ANSWER")
	private String answer;
	
	@Column(name = "ANSWER_IMAGE")
	private String answerImage;
	
	@Column(name = "CREATE_MEMBER")
	private Long createMember;
	
	@Embedded
	private AuditTimes auditTimes;
}
