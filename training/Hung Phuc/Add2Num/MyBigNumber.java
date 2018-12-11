import java.util.*;
class MyBigNumber
{
	// Method to sum 2 String //
	public static String Sum(String s1, String s2)
	{
			
			int l1 = s1.length(); // length of String 1
			int l2 = s2.length(); // length of String 2
			int maxLen = Math.max(l1,l2); // we find out what is largest length between String 1 and String 2
			String result =""; // result
			int mem = 0; // to save 
			for(int i = 0;i < maxLen;i++)
			{
				int index1 = l1 - i - 1;
				int index2 = l2 - i - 1;
				int x;	
				int y;
				
				if(index1 < 0)	// l1 < l2 , so we add 0 to str1 to make it easy for sum
					x = 0;
				else
					x = Convert(s1.charAt(index1));
				
				if(index2 < 0) // l1 > l2 , so we add 0 to str2 to make it easy for sum
					y = 0;
				else
					y = Convert(s2.charAt(index2));
				
				int tmp = mem + x + y; // plus last digit of each String together and with mem
				if(tmp > 9)
				{
					mem = 1; 	// we save 1
					tmp = tmp%10; // and write down the per unit
				}
				else
					mem = 0; // make mem become 0 because tmp <= 9
				
				result = tmp + result; // Sum 
			}
			if(mem == 1) // when we run all length and we still have mem = 1 , so we write 1 at first of result
				result = 1 + result;
			
			return result;
	}
	//Just a method to convert char into number//
	public static int Convert(char x)
	{
		return (x - '0');
	}
}