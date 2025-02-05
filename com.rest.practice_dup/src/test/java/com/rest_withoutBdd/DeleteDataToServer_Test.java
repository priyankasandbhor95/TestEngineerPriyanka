package com.rest_withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteDataToServer_Test {
	
	@Test
	public void deleteData_Test()
	{
		Response resp= RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_11472");
		resp.then().assertThat().statusCode(204);
		resp.then().log().all();
	}

}
