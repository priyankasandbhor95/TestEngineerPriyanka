package com.complexreq;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class postcomplexReqViaHasMapObj_Test {
	@Test
	public void postviahashmapobj_test()
	{
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("createdBy", "priyanka_sandbhor_3");
		map.put("projectName", "testyantra_3");
		map.put("status", "created");
		map.put("teamSize", 0);

		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")

		.then()
		.assertThat().statusCode(201)
		.log().all();
	}


}
