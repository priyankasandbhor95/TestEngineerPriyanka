package autherization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class oauth2_0_test {
	
	@Test
	public void sampleTest()
	{
		
		//api 1
		
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
		
		
		
		//>>>>>>>>>>>> api 2
		given()
		.auth().oauth2(respo_token)
		.log().all()
		
		.when()
		.get("http://49.249.28.218:8091/projects")
		
		.then()
	.log().all();

}
}