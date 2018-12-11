package myjava.mybignumber;

/**
*<b>MyBigNumber<b>
*
*
*/
class MyBigNumber
{
	public String sum(String s1, String s2)
	{
		String result = "";

		String a = "0";
		int len = 0;
	
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		if( s1.length() > s2.length() )
		{
			len = s1.length()  - s2.length();
			for(int i = 0; i<len; i++)
			{
				sb2.insert(i, a);
			}	
		}
		else
		{
			len = s2.length() - s1.length();
			for(int i = 0; i<len; i++)
			{
				sb1.insert(i, a);
			}	
		}

		int len1 = sb1.length();
		int len2 = sb2.length();
		int index1 = 0;
		int index2 = 0; 
		char c1;
		char c2;
		int nho = 0;
		int t = 0 ;
		
		for(int i = 0; i < len1; i++) 
		{
			index1 = (len1 - i -1);
			index2 = (len2 - i -1);
			
			c1 = sb1.charAt(index1);
			c2 = sb2.charAt(index2);
			t = (c1 - '0') + (c2 - '0') + nho;
			result = (t % 10) + result;
			nho = (t / 10);
		}
		if(nho != 0)
		{
			result = nho + result ;
		}

		return result;
	}

}