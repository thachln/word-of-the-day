package myjava.mybignumber;
/*
 * <b>Test</b>
 */
public class Test implements IReceiver{
	public static void main(String[]args)
	{
		MyBigNumber mb = new MyBigNumber(new Test() );
		String  s1  = "1234"; 
		String  s2  = "789";
		System.out.println("Result:"+mb.sum(s1,s2));
		
	}
	

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
}
