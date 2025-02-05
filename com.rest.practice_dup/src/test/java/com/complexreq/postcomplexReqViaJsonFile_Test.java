package com.complexreq;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class postcomplexReqViaJsonFile_Test {
	@Test
	public void postviajsonfile_test()
	{
		File f1=new File("./workingwithjson.json");
		given()
		.body(f1)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")

		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
