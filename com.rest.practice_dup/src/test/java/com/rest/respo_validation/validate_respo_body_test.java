package com.rest.respo_validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class validate_respo_body_test {
	@Test
	public void test()
	{
		Response respo= given().get("http://49.249.28.218:8091/projects-paginated");
		
		respo.then().log().all();
		
		respo.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
		respo.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		
		respo.then().assertThat().body("empty", Matchers.equalTo(false));
		respo.then().assertThat().body("pageable.sort.sorted", Matchers.equalTo(false));
		respo.then().assertThat().body("content[2].projectId", Matchers.equalTo("NH_PROJ_9975"));


		/*
		//****************** data extraction**************
		int itr=respo.jsonPath().get("numberOfElements");
		System.out.println(itr);
		
		Boolean val= respo.jsonPath().get("empty"); 
		System.out.println(val);
		
		Boolean unsort= respo.jsonPath().get("pageable.sort.sorted");
		System.out.println(unsort);//false
		
		String str1=respo.jsonPath().get("content[2].projectId");
		System.out.println(str1);
		
		*/
		
		

	}
	
	

}
