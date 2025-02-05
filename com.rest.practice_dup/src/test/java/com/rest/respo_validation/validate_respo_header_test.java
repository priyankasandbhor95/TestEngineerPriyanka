package com.rest.respo_validation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class validate_respo_header_test {
	@Test
	public void respo_header_vali()
	{
		Response respo=given()
		.get("http://49.249.28.218:8091/projects");
	
		respo.then().log().all();

		respo.then().assertThat().statusCode(200);
		respo.then().assertThat().statusLine("HTTP/1.1 200 ");
		respo.then().assertThat().contentType(ContentType.JSON);
		respo.then().assertThat().header("Transfer-Encoding", "chunked");

	}
}
