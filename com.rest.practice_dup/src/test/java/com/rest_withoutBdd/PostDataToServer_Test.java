package com.rest_withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDataToServer_Test {
	@Test
	public void PostDataToServerTest()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "priyanka");
		jobj.put("projectName", "teckpy");
		jobj.put("status", "created");
		jobj.put("teamSize", 0);

		
		RequestSpecification req =RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj.toJSONString());
		
		Response respo= req.post("http://49.249.28.218:8091/addProject");
		respo.then().assertThat().statusCode(201);
		respo.then().log().all();
	}
}
