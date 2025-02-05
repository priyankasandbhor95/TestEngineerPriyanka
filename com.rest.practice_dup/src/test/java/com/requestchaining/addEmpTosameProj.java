package com.requestchaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.complexreq.xyzpojo_complexrequest;
import com.requestchaining_pojo.EmpPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class addEmpTosameProj {
	
	@Test
	public void addemp()
	{
		
	// API-1>>>>>>>>...........ADD PROJECT
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
		
		String proname=respo.jsonPath().get("projectName");
		System.out.println(proname);
// API-2>>>>>>>>...........ADD EMPLOYEE TO SAME PROJECT
		
		EmpPojo epojo=new EmpPojo("architect", "08/09/1995", "priyanka@gmail.com", "user_"+num, 18, "9527710027", proname, "ROLE_EMPLOYEE",  "user_"+num);
		
				given()
				.body(epojo)
				.contentType(ContentType.JSON)
				
				.when()
				.post("http://49.249.28.218:8091/employees")

				.then()
				.assertThat().statusCode(201)
				.log().all();

	}
	

}
