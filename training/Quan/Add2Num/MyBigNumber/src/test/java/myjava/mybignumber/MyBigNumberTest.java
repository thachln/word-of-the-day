package myjava.mybignumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyBigNumberTest implements IReceiver{

	@Test
    public void testSum_N_1() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("1", "2");
        
        assertEquals("3", sum);
        
        String s = mb.sum("8", "2");
        
        assertEquals("10", s);
    }
	
	@Test
	public void testSum_N_2() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("123", "9");
        
        assertEquals("132", sum);
	}
	
	@Test
	public void testSum_N_3() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("111111111111111111111111111111", "222222222222222222222222222222");
        
        assertEquals("333333333333333333333333333333", sum);
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
	
	}

}
