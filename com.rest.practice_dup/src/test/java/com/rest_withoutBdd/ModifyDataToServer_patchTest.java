package com.rest_withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ModifyDataToServer_patchTest {
	@Test
	public void patchDataToServer()
	{
		
	
	JSONObject jobj=new JSONObject();
	jobj.put("projectName", "teckpy_pune");

	
	RequestSpecification req =RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jobj.toJSONString());
	
	Response respo= req.patch("http://49.249.28.218:8091/project/NH_PROJ_11472");
	//put req is for complete modification if you wants modify specific then go for patch
	
	respo.then().assertThat().statusCode(200);
	respo.then().log().all();
	}

}
