package com.typeOfParam;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class paramParam {
	@Test
	public void generic_test()
	{
			
//			given()
//			.param("teamSize",0)
//			.log().all()
//			.when()
//			.post("http://49.249.28.218:8091/project")///param along with post acts like form param
//			.then();
//				//.log().all();
			
			
			given()
			.param("teamSize",0)
			.log().all()
			.when()
			.get("http://49.249.28.218:8091/project")///param along with get acts like query param
			.then();
				//.log().all();


}
}
