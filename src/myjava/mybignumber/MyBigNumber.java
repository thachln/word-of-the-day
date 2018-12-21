package myjava.mybignumber;
/**
*<b>MyBigNumber<b> 
*
*
*/
class MyBigNumber 
{
	private IReceiver ireceiver;
	public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }
	public String sum(final String s1,final String s2) // tham so truyen vao s1, s2 
	{
		String result = ""; // dung de tra ve ket qua  kieu chuoi
		int len1 = s1.length(); // chieu dai s1 
		int len2 = s2.length();// chieu dai s2
		int maxLen = (len1 > len2) ? len1 : len2; // so sanh 2 chuoi roi lay chuoi nao day nhat
		int index1 = 0; // xac dinh vi tri chuoi cua s1
		int index2 = 0; // xac dinh vi tri chuoi cua s2
		char c1; // lay tung ki tu cua chuoi s1
		char c2; // lay tung ki tu cua chuoi s2
		
		String msg = "";
		int nho = 0; // khi cong 2 so neu >=10 se du 1
		int t = 0 ; // dung de cong 2 so khi chuyen ki tu thanh chuoi
		
		for(int i = 0; i < maxLen; i++) 
		{
			index1 = (len1 - i -1); // xac dinh vi tri chuoi s1 tu phai sang trai
			index2 = (len2 - i -1); // xac dinh vi tri chuoi s2 tu phai sang trai
			
			c1 = (index1 >= 0) ? s1.charAt(index1) : '0'; // khi kiem tra den den het vi tri dau tien tu trai sang phai thi se  them '0' de 2 chuoi bang nhau
			c2 = (index2 >= 0) ? s2.charAt(index2) : '0';

			t = (c1 - '0') + (c2 - '0') + nho; // thuc hien phep cong 
			result = (t % 10) + result; // lay ket qua phan du gan vao result thanh 1 chuoi
			
			nho = (t / 10); // lay phan nguyen 0 or 1 neu du 1 se cong vao t

			msg = "Buoc:" +(i+1)+    "   " +(c1-'0')+"   +  " +(c2-'0')+" = " + ( (c1-'0') + (c2 - '0') ) + " viet:"+(t % 10)+ 
					" nho:"+nho; 
			this.ireceiver.send(msg);
		}
		if(nho != 0){
			result = nho + result ;
			
		}

		return result;
	}
}


