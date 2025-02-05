package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class encode_decode_test {
	@Test
	public void sampleTest()
	{
		
		String encode=new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(encode);//QUJD
		
	String decode=new String(Base64.getDecoder().decode(encode.getBytes()));
	System.out.println(decode);//ABC
		
	}
	

}
