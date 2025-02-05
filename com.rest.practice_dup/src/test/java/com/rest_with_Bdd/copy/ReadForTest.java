package com.rest_with_Bdd.copy;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadForTest {
	@Test
	public void getDataFromServerTest()
	{
		//when()
		given()
		.get("http://49.249.28.218:8091/projects")
	.then()
		.assertThat().statusCode(200)
		.log().all();
		
//		Response resp= RestAssured.get("http://49.249.28.218:8091/projects");
//		System.out.println(resp.prettyPrint());//json format responce
//		//System.out.println(resp.asString());//string format respo
//
//		resp.then().assertThat().statusCode(200);
//		resp.then().log().all();
	}

}
