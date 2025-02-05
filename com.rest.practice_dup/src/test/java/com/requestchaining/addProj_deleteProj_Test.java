package com.requestchaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.complexreq.xyzpojo_complexrequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class addProj_deleteProj_Test {
	
	@Test
	public void addProjtoserver_test()
	{
		
		Random random=new Random();
		int num=random.nextInt(2000);
		System.out.println(num);
		xyzpojo_complexrequest objpojo=new xyzpojo_complexrequest("Airtel_"+num, "netra", "ongoing",10);
		
	Response respo=	given()
		.body(objpojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://49.249.28.218:8091/addProject");

		respo.then()
		.assertThat().statusCode(201)
		.log().all();
		
		//capture proj_name.respo
		
		String proId=respo.jsonPath().get("projectId");
		System.out.println(proId);
		
		//delete same proj
		given()
		.delete("http://49.249.28.218:8091/project/"+proId)
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}
