package autherization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestAuthTest2 {
	
	@Test
	public void digestTest()
	{
		
		//ninza pay application login
		//49.249.29.5:8091/swager-ui.html
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.log().all()
		
		.when()
		.get("http://49.249.29.5:8091/login")
		
		.then()
		.log().all();
	
	
	}
}
