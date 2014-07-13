import junit.framework.TestCase;


public class StringCalculator2Test extends TestCase {
	StringCalculator2 cal;
	@Override
	protected void setUp() throws Exception {
		System.out.println("setUp!");
		cal = new StringCalculator2();
	}
	
	public void testAddWhenEmpty() {
		System.out.println("test!");
		assertEquals(0,cal.add(""));
	}
	
	public void testAddWhenOneNumber() throws Exception {
		System.out.println("test!");
		assertEquals(3,cal.add("3"));
	}
	
	public void testAddWhenTwoNumber() throws Exception {
		System.out.println("test!");
		assertEquals(3,cal.add("1,2"));		
	}
	
	public void testAddWhenThreeNumber() throws Exception {
		System.out.println("test!");
		assertEquals(6,cal.add("1,2,3"));		
	}
	
	public void testAddWhenThreeNumberNNewLine() throws Exception {
		System.out.println("test!");
		assertEquals(6,cal.add("1\n2\n3"));		
	}
	
	public void testAddWhenThreeNumberNCommaNNewLine() throws Exception {
		System.out.println("test!");
		assertEquals(6,cal.add("1,2\n3"));		
	}

	public void testSum() {
		System.out.println("test!");
		int[] number = {1,2,3};
		int values = cal.sum(number);
		assertEquals(6, values);
	}

	public void testToInt() {
		System.out.println("test!");
		String[] numbers = {"1","2","3"};
		int[] values = cal.toInt(numbers);
		int[] realvalues = {1,2,3};
		assertEquals(realvalues, values);
	}

	public void testSplit() {
		System.out.println("test!");
		String[] values = cal.split("1\n2,3");
		String[] realvalues = {"1","2","3"};
		assertEquals(realvalues, values);
	}
	
	@Override
	protected void tearDown() throws Exception {
		System.out.println("tearDown!");

	}
}
