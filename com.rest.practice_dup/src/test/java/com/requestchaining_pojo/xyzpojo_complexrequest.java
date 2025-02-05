package com.requestchaining_pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class xyzpojo_complexrequest
{
	private String projectName;
	private String createdBy;
	private String status;
	private int teamsize;
	
	private xyzpojo_complexrequest() {
		
	}
	
	public xyzpojo_complexrequest(String projectName, String createdBy, String status, int teamsize) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.status = status;
		this.teamsize = teamsize;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	
	

}