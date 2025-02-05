package com.rest.practice.seralization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jacksonDeseri_Test {
	@Test
	public void desTest() throws StreamReadException, DatabindException, IOException
	{
		ObjectMapper omap=new ObjectMapper();
		project pobj=omap.readValue(new File("./project.json"), project.class);
		
		System.out.println( pobj.getProjectName());
		System.out.println( pobj.getCreatedBy());
		System.out.println( pobj.getStatus());
		System.out.println( pobj.getTeamsize());

	}

}
