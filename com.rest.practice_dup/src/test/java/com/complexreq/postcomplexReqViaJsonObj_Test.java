package com.complexreq;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class postcomplexReqViaJsonObj_Test {
	
	@Test
	public void postviajsonobj_test()
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
