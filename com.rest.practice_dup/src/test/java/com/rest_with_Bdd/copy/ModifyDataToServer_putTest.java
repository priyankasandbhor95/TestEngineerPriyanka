package com.rest_with_Bdd.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ModifyDataToServer_putTest {
	@Test
	public void putDataToServer()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "priyanka_3");
		jobj.put("projectName", "testyantra_3");
		jobj.put("status", "OK");
		jobj.put("teamSize", 0);

		
		given()
		 .body(jobj.toJSONString())
		 .contentType(ContentType.JSON)
		 
		.when()
		 .put("http://49.249.28.218:8091/project/NH_PROJ_11483")

		
		.then()
		  .assertThat().statusCode(200)
		  .log().all();
		
		
	}

}
