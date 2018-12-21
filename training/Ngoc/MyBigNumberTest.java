package myjava.mybignumber;
/**
*<b>MyBigNumberTest<b>
*
*
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyBigNumberTest implements IReceiver
{

	@Test
	void test() 
	{
		MyBigNumber myClass = new MyBigNumber(this);
		String sum = myClass.sum("1", "09");
		assertEquals("10", sum);
		
		sum = myClass.sum("8", "9");
		assertEquals("17", sum);
	}
	@Test void testSum_N_2() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("123", "9");
			assertEquals("132", sum); 
	}
	@Test void testSum_N_3() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("999", "9");
			assertEquals("1008", sum); 
	}
	
	@Test void testSum_N_4() 
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
	@Test void testSum_N_6() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("0", "");
			assertEquals("0", sum); //False: 0
	}
	
	@Test void testSum_N_7() 
	{
			MyBigNumber myClass = new MyBigNumber(this);
			String sum = myClass.sum("", "");
			assertEquals("", sum);
	}
	 
    public void send(String msg) {
		// TODO Auto-generated method stub
	}

}
