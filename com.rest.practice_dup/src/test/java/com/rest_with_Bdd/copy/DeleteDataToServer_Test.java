package com.rest_with_Bdd.copy;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DeleteDataToServer_Test {
	
	@Test
	public void deleteData_Test()
	{
		//when()
		given().
	       delete("http://49.249.28.218:8091/project/NH_PROJ_11483")
		.then()
		   .assertThat().statusCode(204)
		   .log().all();
	}

}
