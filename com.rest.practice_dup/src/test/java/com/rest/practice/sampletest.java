package com.rest.practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class sampletest {
	@Test
	public void sampleTest()
	{
		get("https://reqres.in/api/users?page=2").then().log().all();
		
//		Response body= RestAssured.get("https://reqres.in/api/users?page=2");
//	System.out.println(body.prettyPrint());
	}

}
