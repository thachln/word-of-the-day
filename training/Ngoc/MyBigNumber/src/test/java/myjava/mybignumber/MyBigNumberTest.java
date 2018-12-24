package myjava.mybignumber;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
*<b>MyBigNumberTest<b>
*
*
*/

public class MyBigNumberTest implements IReceiver
{

	@Test
	public void testSum_N_1() 
	{
		MyBigNumber myClass = new MyBigNumber(this);
		String sum = myClass.sum("1", "09");
		assertEquals("10", sum);
		
		sum = myClass.sum("8", "9");
		assertEquals("17", sum);
	}
	@Test
	public void testSum_N_2() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("123", "9");
			assertEquals("132", sum); 
	}
	@Test
	public void testSum_N_3() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("999", "9");
			assertEquals("1008", sum); 
	}
	
	@Test
	public void testSum_N_4() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("00999", "009");
			assertEquals("01008", sum); 
	}
	
	/*@Test void testSum_N_5() 
	{
			MyBigNumber myClass = new MyBigNumber();
			String sum = myClass.sum("", "aadd");
			assertEquals("", sum); //False: don't have charracter
	}*/	
	@Test
	public void testSum_N_6() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("0", "");
			assertEquals("0", sum); //False: 0
	}
	
	@Test
	public void testSum_N_7() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("", "");
			assertEquals("", sum);
	}
	 
    public void send(String msg) {
		// TODO Auto-generated method stub
	}

}
