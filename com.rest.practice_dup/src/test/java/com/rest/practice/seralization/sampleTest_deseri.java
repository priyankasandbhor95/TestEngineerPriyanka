package com.rest.practice.seralization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import io.restassured.response.Response;

public class sampleTest_deseri{
	@Test
	public void live_gameTest() throws IOException, ClassNotFoundException
	{
		//gameTest game=new gameTest("priya", 10, 50000, 2);
		FileInputStream fin=new FileInputStream("./f1.txt");
		ObjectInputStream objin =new ObjectInputStream(fin);
		gameTest user1=(gameTest) objin.readObject();
		System.out.println(user1.name);
		System.out.println(user1.level);
		System.out.println(user1.score);
		System.out.println(user1.life);

		
		System.out.println("======done de-serializaltion=======");
	}

}
