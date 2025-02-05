package com.rest.practice.seralization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
@JsonPropertyOrder(value= {"status","teamsize","createdBy","projectName"})
@JsonIgnoreProperties(value = {"teamsize"},allowSetters = true)

class project
{
	private String projectName;
	@JsonProperty(value="created By")
	private String createdBy;
	private String status;
	private int teamsize;
	
	private project() {
		
	}
	
	public project(String projectName, String createdBy, String status, int teamsize) {
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
public class jacksonSer_Test {
	
	@Test
	public void jacksonTest() throws StreamWriteException, DatabindException, IOException
	{
		project pobj=new project("orange", "priyanka", "ongoing", 10);
		ObjectMapper omap=new ObjectMapper();
		omap.writeValue(new File("./project.json"), pobj);
		System.out.println("===========end==========");
		
	}

}
