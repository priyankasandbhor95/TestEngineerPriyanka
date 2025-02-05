package com.rest.respo_validation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class verifyComplexdataJsonXpath_test {
	@Test
	public void test()
	{
Response respo= given().get("http://49.249.28.218:8091/projects-paginated");
		
		respo.then().log().all();
		
	ArrayList<String> lst=	JsonPath.read(respo.asString(),"content[*].projectId");
	for (String string : lst) {
		System.out.println(string);
	}
	
	//extract particular proj_name & that proj_name's proj_id and validate that id
	ArrayList<String> lt= JsonPath.read(respo.asString(),"content[*].[?(@.projectName=='ABB_43931')].projectId");
	String actid= lt.get(0);
	
	Assert.assertEquals(actid,"NH_PROJ_9973");
	}

}
