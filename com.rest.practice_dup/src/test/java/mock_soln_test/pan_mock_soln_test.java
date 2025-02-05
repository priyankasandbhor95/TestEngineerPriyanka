package mock_soln_test;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

class mock_test{
	//********************STUB SOLN
	public static mock_test get_mock_obj()
	{
		mock_test mockobj =Mockito.mock(mock_test.class);
		
		Mockito.when(mockobj.isValid("ABCDE1234D")).thenReturn("valid pan card");
		Mockito.when(mockobj.isValid("ABCDE1234C")).thenReturn("valid pan card");
		Mockito.when(mockobj.isValid("ABCDE1234B")).thenReturn("Invalid pan card");

		return mockobj;
	}
	
	public  String isValid(String panNum)
	{
		
		if(panNum.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true){
			return "is valid panCard";
		}
		else
		{
			return "invalid panCard";
		}
	}
	
}

public class pan_mock_soln_test {
	
	
	public static void main(String[] args) {
//		System.out.println(mock_test.isValid("ABCDE1234D"));

		mock_test mtest=mock_test.get_mock_obj();
		System.out.println(mtest.isValid("ABCDE1234A"));
	}
	

}
