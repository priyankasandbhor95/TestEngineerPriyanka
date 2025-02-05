package com.rest.respo_validation;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class validate_respo_header_RespoTime_test {
	@Test
	public void respo_header_vali()
	{
		Response respo=given()
				.get("http://49.249.28.218:8091/projects");
		
		Long time=respo.time();
		System.out.println("****** "+time+" ******");
		respo.then().assertThat().time(Matchers.lessThan(1000l));
		respo.then().assertThat().time(Matchers.greaterThan(300l));
		respo.then().assertThat().time(Matchers.both(Matchers.lessThan(900l)).and(Matchers.greaterThan(300l)));
		
	}

}
