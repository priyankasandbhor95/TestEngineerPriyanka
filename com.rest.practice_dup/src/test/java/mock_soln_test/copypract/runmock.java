package mock_soln_test.copypract;

public class runmock{
	public static void main(String[] args) {
	Mocking mtest=	Mocking.getmockObj();
			System.out.println(mtest.isValid("ABCDE1234A"));
			System.out.println(mtest.isValid("ABCDE1234B"));
			System.out.println(mtest.isValid("ABCDE1234C"));
			System.out.println(mtest.isValid("ABCDE1234D"));

	}
}
