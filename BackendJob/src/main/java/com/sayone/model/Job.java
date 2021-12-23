package com.sayone.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jobId;
	private String description;
	private String status;
	private Date startDate;
	private Date endDate;
	private Date updateDate;
	private String errors;
	private Boolean isActiveFlag;
	
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public Boolean getIsActiveFlag() {
		return isActiveFlag;
	}
	public void setIsActiveFlag(Boolean isActiveFlag) {
		this.isActiveFlag = isActiveFlag;
	}
	
	@Override
	public String toString() {
		return "JobDto [jobId=" + jobId + ", description=" + description + ", status=" + status + ", startDate="
				+ startDate + ", endDate=" + endDate + ", updateDate=" + updateDate + ", errors=" + errors
				+ ", isActiveFlag=" + isActiveFlag + "]";
	}
}
