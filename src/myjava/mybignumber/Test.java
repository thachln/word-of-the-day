package myjava.mybignumber;
import java.util.*;
/*
 * <b>Test</b>
 */
public class Test implements IReceiver{
	
	
	private static Scanner sc;

	public static void main(String[]args)
	{
		MyBigNumber mb = new MyBigNumber(new Test() );
		sc = new Scanner(System.in);
		
		System.out.println("Nhap s1:");
		String s1 = sc.nextLine();
		System.out.println("Nhap s2:");
		String s2 = sc.nextLine();
		
		System.out.println("Result:"+mb.sum(s1,s2));
		
	}
	
	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
}
