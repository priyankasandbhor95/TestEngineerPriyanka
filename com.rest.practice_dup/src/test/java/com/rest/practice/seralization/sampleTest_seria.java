package com.rest.practice.seralization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import io.restassured.response.Response;

class gameTest implements Serializable {
	String name;
	int level;
	long score;
	int life;
	public gameTest(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
	
	
}
public class sampleTest_seria{
	@Test
	public void live_gameTest() throws IOException
	{
		gameTest game=new gameTest("priya", 10, 50000, 2);
		FileOutputStream fout=new FileOutputStream("./f1.txt");
		ObjectOutputStream objout =new ObjectOutputStream(fout);
		objout.writeObject(game);
		
		System.out.println("======done serializaltion=======");
	}

}
