package mock_soln_test;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class paytest {
	@Test
	public void sampleTest()
	{
	JSONObject obj=new JSONObject();
	obj.put("creditcard", "1234567891235");
	obj.put("cvv", "123");
	obj.put("cardname", "Priyanka");
	
	given()
	.body(obj)
	.when()
	.post("http://localhost:8889/credit-card")
	.then().log().all();
	}

}
