package mock_soln_test.copypract;

import org.mockito.Mockito;

class Mocking {
	
	 String isValid(String pannum)
	{
		
		if(pannum.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
		{
			return "valid pan format";

		}
		else
		{
			return "Invalid pan format";

		}
		
	}
	
	public static Mocking getmockObj()
	{
	Mocking mobj=Mockito.mock(Mocking.class);
	
				Mockito.when(mobj.isValid("ABCDE1234A")).thenReturn("verified pan num");
				Mockito.when(mobj.isValid("ABCDE1234B")).thenReturn("verified pan num");
				Mockito.when(mobj.isValid("ABCDE1234C")).thenReturn("not-verified pan num");
				Mockito.when(mobj.isValid("ABCDE1234")).thenReturn("verified pan num");


				return mobj;
	}

}
