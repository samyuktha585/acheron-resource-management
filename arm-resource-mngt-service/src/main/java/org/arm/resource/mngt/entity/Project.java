package org.arm.resource.mngt.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {

	@Id
	private int projectId;
	private String projectName;
	private String projectOwner;
	private Timestamp startDate;
	private Timestamp endDate;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Timestamp createDate;
	private Timestamp updateDate;
	private int isDeleted;
	private String created_by;
	private String updated_by;
	
	@ManyToOne
	@JoinColumn(name="campaign_id")
	private Campaign campaign;

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectOwner=" + projectOwner + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", priority=" + priority + ", status=" + status + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", isDeleted=" + isDeleted + ", created_by=" + created_by
				+ "]";
	}
	
}
