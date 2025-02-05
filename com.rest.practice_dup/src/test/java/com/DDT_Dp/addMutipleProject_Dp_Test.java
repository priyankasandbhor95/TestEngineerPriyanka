package com.DDT_Dp;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.complexreq.xyzpojo_complexrequest;
import com.rest.Excel_utility.ExcelUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class addMutipleProject_Dp_Test {
	
	@Test(dataProvider = "getData")
	public void sampleTest_Dp_Test(String pName,String status)
	{
		xyzpojo_complexrequest pojoobj=new xyzpojo_complexrequest(pName, "priyanka", status, 0);
		
		
		
		given()
		.contentType(ContentType.JSON)
		.body(pojoobj)
		.when()
		    .post("http://49.249.28.218:8091/addProject")
		.then()
			.log().all();
		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eLib=new ExcelUtility();
	    int rowcount=eLib.getRowCount("Sheet1");
	    
	    Object[][] obj=new Object[rowcount][2];
	    
		for(int i=0;i<rowcount;i++)
		{
			obj[i][0]=eLib.getDataFromExcel("Sheet1", i+1, 0);
			obj[i][1]=eLib.getDataFromExcel("Sheet1", i+1, 1);

			

		}
	return obj;
		
	}

}
