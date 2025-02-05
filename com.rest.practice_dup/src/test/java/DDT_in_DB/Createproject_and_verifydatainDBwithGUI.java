package DDT_in_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class Createproject_and_verifydatainDBwithGUI {

	public static void main(String[] args) throws SQLException {
		
	//*************create project in GUI*************(selenium)	
		
		
		// Launch Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicit wait
		
		//navigate to ninza hrm
		driver.get("http://49.249.28.218:8091/");
		
		//login to app
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		//click on project option
		driver.findElement(By.linkText("Projects")).click();
		
		//try to create project on clicking create_project button
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		Random random=new Random();
		int num=random.nextInt(2000);
		String proj_name="Insta_"+num;

		//filling project details and add project
		
		driver.findElement(By.name("projectName")).sendKeys(proj_name);
		driver.findElement(By.name("createdBy")).sendKeys("Priyanka");
		Select sel=new Select(driver.findElement(By.xpath("(//select[@name=\"status\"])[2]")));
		sel.selectByValue("On Going");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//********************* verify project in database
		boolean flag=false;
		String expdata="fbi5";
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
	    Statement stmt= conn.createStatement();
	   ResultSet resset=  stmt.executeQuery("select * from project");
	   while(resset.next())
	   {
		   String actdata=resset.getString(4);
		   System.out.println(actdata);
		   if(proj_name.equals(actdata))
		   {
			   flag=true;
			   System.out.println(proj_name+" is avilable ====>PASS");
		   }
	   }
	   
	   if(flag==false)
	   {
		   System.out.println(proj_name+" is not avilable ====>FAIL");
		   Assert.fail();
	   }
	   
	   conn.close();
		
		driver.quit();
	}
	
}
