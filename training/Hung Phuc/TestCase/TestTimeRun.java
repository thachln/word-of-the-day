public class TestTimeRun implements IReceiver{
	
	public static void main(String[]args){
		
		MyBigNumber a = new MyBigNumber(new TestTimeRun());
		String num1 = "";
		String num2 = "";
		String str1 = "12343456789845234587";
		String str2 = "98389898478734672364";
		//we create two numbers with contain 100 character by loop str1 and str 2
		
		for(int i = 0;i < 5;i++){
			num1 = num1 + str1;
			num2 = num2 + str2;
		}
		
		int nRun = 100; //This is for run how many times
		long startTime = System.currentTimeMillis();
		for(int i = 0;i < nRun;i++){//We will run this function 1000 times to calculate average time
			a.Sum(num1,num2);
		}
		long stopTime = System.currentTimeMillis();
		long timeCollapse = stopTime - startTime;
		long avgTime = 1000*timeCollapse/nRun;
		System.out.println();
		System.out.println("/////Average Time run: "+ avgTime +" microsecond when run 1000 characters");
		
	}
	@Override
    public void send(String msg){
        System.out.println(msg);
    }
}
