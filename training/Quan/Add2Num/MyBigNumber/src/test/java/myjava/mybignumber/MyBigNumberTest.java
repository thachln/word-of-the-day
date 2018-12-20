package myjava.mybignumber;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.internal.bytebuddy.asm.Advice.Thrown;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
		String sum = mb.sum("123", "7");
        
        assertEquals("130", sum);
	}
	
	@Test
	public void testSum_N_3() {
		MyBigNumber mb = new MyBigNumber(this);
		String sum = mb.sum("111111111111111111111111111111", "222222222222222222222222222222");
        
        assertEquals("333333333333333333333333333333", sum);
	}
	
	@Test
	public void testSum_N_4() {
		
		assertThrows(NumberFormatException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				MyBigNumber mb = new MyBigNumber(MyBigNumberTest.this);
				String sum = mb.sum("1ab", "123");
				
			}
		});
		
	}
	
	@Test
	public void testSum_N_5() {
		assertThrows(NumberFormatException.class, new Executable() {
			
		@Override
		public void execute() throws Throwable {
				// TODO Auto-generated method stub
				MyBigNumber mb = new MyBigNumber(MyBigNumberTest.this);
				String sum = mb.sum("-1", "123");
				
			}
		});
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		
		
	
	}

}
