package com.rest_with_Bdd.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDataToServer_Test {
	@Test
	public void PostDataToServerTest()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "priyanka_sandbhor_2");
		jobj.put("projectName", "testyantra_2");
		jobj.put("status", "created");
		jobj.put("teamSize", 0);

		given()
		.body(jobj.toJSONString())
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")

		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
		
		
		
	}
}
