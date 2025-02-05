package autherization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class premptiveTest {
	@Test
	public void preTest()
	{
		
		//ninza pay application login
		//49.249.29.5:8091/swager-ui.html
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.log().all()
		
		.when()
		.get("http://49.249.29.5:8091/login")
		
		.then()
		.log().all();
	


}
}
