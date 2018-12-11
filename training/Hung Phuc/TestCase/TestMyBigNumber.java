import java.util.*;
class TestMyBigNumber
{
	public static void main(String[]args)
	{
		
		MyBigNumber a = new MyBigNumber();
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
		
		//Time Run
		num1 = "";
		num2 = "";
		String str1 = "12343456789845234587";
		String str2 = "98389898478734672364";
		//we create two numbers with contain 1000 character by loop str1 and str 2
		for(int i = 0;i < 50;i++)
		{
			num1 = num1 + str1;
			num2 = num2 + str2;
		}
		int nRun = 2000; //This is for run how many times
		long startTime = System.currentTimeMillis();
		for(int i = 0;i < nRun;i++)//We will run this function 1000 times to calculate average time
		{
			a.Sum(num1,num2);
		}
		long stopTime = System.currentTimeMillis();
		long timeCollapse = stopTime - startTime;
		long avgTime = 1000*timeCollapse/nRun;
		System.out.println("Average Time run: "+ avgTime +" microsecond when run 1000 characters");
	}
}