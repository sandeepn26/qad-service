package com.qad.db.entity.team;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamMemberMapId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "MEMBER_ID")
	private Long memberId;
	
	@Column(name = "TEAM_ID")
	private Long teamId;
	
	public TeamMemberMapId(Long memberId, Long teamId) {
		this.memberId = memberId;
		this.memberId = memberId;
	}
	
}
