import java.util.*;
class UnitTest implements IReceiver{
	public static void main(String[]args){
		
		MyBigNumber a = new MyBigNumber(new UnitTest());
		String num1;
		String num2;
		
		//Test 1: num1 length larger than num2
		num1 = "1234";
		num2 = "50";
		System.out.println("///////Test 1///////");
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+ num2);
		System.out.println("Test1 result: "+ a.Sum(num1,num2));
		System.out.println();
		
		//Test 2: num1 length smaller than num2
		num1 = "12";
		num2 = "600";
		System.out.println("///////Test 2///////");
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+ num2);
		System.out.println("Test2 result: "+ a.Sum(num1,num2));
		System.out.println();
		
		//Test 3: num1 length equal num2
		num1 = "123";
		num2 = "456";
		System.out.println("///////Test 3///////");
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+ num2);
		System.out.println("Test3 result: "+ a.Sum(num1,num2));
		System.out.println();
		
		//Test 4: num1 + num2 và dư ra số 1 ở đầu kết quả
		num1 = "999";
		num2 = "1";
		System.out.println("///////Test 4///////");
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+ num2);
		System.out.println("Test4 result: "+ a.Sum(num1,num2));
		System.out.println();
		
		//Test 5: Nhập kí tự không hợp lệ
		num1 = "1235";
		num2 = "a56798";
		System.out.println("///////Test 4///////");
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+ num2);
		System.out.println("Test4 result: "+ a.Sum(num1,num2));
		System.out.println();
	}
	
	@Override
    public void send(String msg){
        System.out.println(msg);
    }
}