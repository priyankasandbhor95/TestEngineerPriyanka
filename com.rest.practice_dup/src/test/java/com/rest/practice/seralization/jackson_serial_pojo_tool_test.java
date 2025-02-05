package com.rest.practice.seralization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Projmainpojo {

	   String name;

	   int salary;

	   boolean BE;

	   String Address;

	   Depart Depart;

	   List<String>  Stream;

	   public Projmainpojo(){}
	    public Projmainpojo(String name, int salary, boolean bE, String address,Depart depart, List<String> stream) {
		super();
		this.name = name;
		this.salary = salary;
		BE = bE;
		Address = address;
		Depart = depart;
		Stream = stream;
	}
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setSalary(int salary) {
	        this.salary = salary;
	    }
	    public int getSalary() {
	        return salary;
	    }
	    
	    public void setBE(boolean BE) {
	        this.BE = BE;
	    }
	    public boolean getBE() {
	        return BE;
	    }
	    
	    public void setAddress(String Address) {
	        this.Address = Address;
	    }
	    public String getAddress() {
	        return Address;
	    }
	    
	    public void setDepart(Depart Depart) {
	        this.Depart = Depart;
	    }
	    public Depart getDepart() {
	        return Depart;
	    }
		public List<String> getStream() {
			return Stream;
		}
		public void setStream(List<String> stream) {
			Stream = stream;
		}
	    
	  
	    
	}

class Depart {

	   String Dept;


	    public Depart(String dept) {
		super();
		Dept = dept;
	}
		public void setDept(String Dept) {
	        this.Dept = Dept;
	    }
	    public String getDept() {
	        return Dept;
	    }
	    
	}

public class jackson_serial_pojo_tool_test {
	
	
	@Test
	public void done() throws StreamWriteException, DatabindException, IOException
	{
	Depart dept =new Depart("IT");
	List<String> lst=new ArrayList<String>();
	
	
	Projmainpojo pro1=new Projmainpojo("Comp", 50000, true, "xyz", dept, lst);
	
	ObjectMapper omap=new ObjectMapper();
	omap.writeValue(new File("./toolpojo.json"), pro1);
	
	}
}
