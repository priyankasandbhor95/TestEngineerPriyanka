package com.rest_withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadForTest {
	@Test
	public void getDataFromServerTest()
	{
		Response resp= RestAssured.get("http://49.249.28.218:8091/projects");
		System.out.println(resp.prettyPrint());//json format responce
		//System.out.println(resp.asString());//string format respo

		resp.then().assertThat().statusCode(200);
		resp.then().log().all();
	}

}
