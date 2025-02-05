package com.requestchaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class getpayrollinfoviaauth_test {
	
	@Test
	public void payrol_test()
	{
		//API 1>>>>>>>>>>AUTHANTICATION
		
			Response respo=	given()
				.formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials")
		
				.when()
				.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		
		       respo.then()
				.assertThat().statusCode(200)
				.log().all();
				
				//extract auth token from respo >>>>>>>>>>>>>>>>>>>>> 
		      String respo_token= respo.jsonPath().get("access_token");
		      
		      System.out.println(respo_token);
		
		
	//API 2>>>>>>>>>>>PAYROLL INFO
			given()
				.auth().oauth2(respo_token)
				.get("http://49.249.28.218:8091/admin/payrolls")

		    .then()
			.log().all()
			.assertThat().statusCode(200);
	}

}
