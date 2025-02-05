package com.complexreq;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class postcomplexReqViaPOJO_Test {
	@Test
	public void postviaPojo_test()
	{
		
	Random random=new Random();
	int num=random.nextInt(2000);
	xyzpojo_complexrequest objpojo=new xyzpojo_complexrequest("Teckm_"+num, "netra", "ongoing",10);
	
	given()
	.body(objpojo)
	.contentType(ContentType.JSON)
	
	.when()
	.post("http://49.249.28.218:8091/addProject")

	.then()
	.assertThat().statusCode(201)
	.log().all();
	}
}
