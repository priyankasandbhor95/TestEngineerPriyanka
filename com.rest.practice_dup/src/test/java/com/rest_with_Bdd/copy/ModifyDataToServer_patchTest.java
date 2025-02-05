package com.rest_with_Bdd.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ModifyDataToServer_patchTest {
	@Test
	public void patchDataToServer()
	{
		
	
	JSONObject jobj=new JSONObject();
	jobj.put("projectName", "testyantra_pune");

	
	given()
	    .contentType(ContentType.JSON)
	    .body(jobj.toJSONString())
	    
	.when()
	    .patch("http://49.249.28.218:8091/project/NH_PROJ_11483")
	//put req is for complete modification if you wants modify specific then go for patch
	
	.then()
	   .assertThat().statusCode(200)
	   .log().all();
	}

}
