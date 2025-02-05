package com.typeOfParam;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class path_param_test {
	@Test
public void path_test()
{
		
		given()
		.pathParam("projectId", "NH_PROJ_9930")
		.when()
		.get("http://49.249.28.218:8091/project/{projectId}")
		.then()
			.log().all();
}
}
