import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:  Nguyen Hung Phuc.
 * DesCription : This is MyBigNumber class which can sum 2 number and return a String.
 */
 
public class MyBigNumber{
	
	private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }

	// Method to sum 2 String //
	public String Sum(final String s1,final String s2){
			
			String msg = "";
			int l1 = s1.length(); // length of String 1
			int l2 = s2.length(); // length of String 2
			int maxLen = Math.max(l1,l2); // we find out what is largest length between String 1 and String 2
			String result =""; // result
			int mem = 0; // to save
			int B = 1;//to save how many step we use
			
			//Check user input right or wrong ?
			for (int i = 0; i < l1; i++){
				if (Character.isLetter(s1.charAt(i))){
					throw new NumberFormatException("Position " + (i + 1) + " in String " + s1
                        + " not a number");
				}
			}

			for (int i = 0; i < l2; i++){
				if (Character.isLetter(s2.charAt(i))) {
					throw new NumberFormatException("Position" + (i + 1) + " in String " + s2
                        + " not a number");
				}
			}
			
			Pattern pattern1 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]");
			Matcher matcher1 = pattern1.matcher(s1);
			Pattern pattern2 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]");
			Matcher matcher2 = pattern1.matcher(s2);
			
			if (matcher1.find()) {
				throw new NumberFormatException("Position " + (matcher1.start() + 1) + " in String " + s1
                    + " not a number");
			}

			if (matcher2.find()) {
				throw new NumberFormatException("Position " + (matcher2.start() + 1) + " in String " + s2
                    + " not a number");
			}
			
			
			//Code for sum
			for(int i = 0;i < maxLen;i++){
				int index1 = l1 - i - 1;
				int index2 = l2 - i - 1;
				int x;	
				int y;
				
				// l1 < l2 , so we add 0 to str1 to make it easy for sum
				if(index1 < 0){	
					x = 0;
				}
				else{
					x = Convert(s1.charAt(index1));
				}
				
				// l1 > l2 , so we add 0 to str2 to make it easy for sum
				if(index2 < 0){ 
					y = 0;
				}
				else{
					y = Convert(s2.charAt(index2));
				}
				
				int tmp = mem + x + y; // plus last digit of each String together and with mem
				int tmp2; //to save value of tmp before changing tmp value
				
				if(tmp > 9){
					mem = 1; 	// we save 1
					tmp2 = tmp; //save value of tmp for print
					tmp = tmp%10; // and write down the per unit
				
				}
				else{
					mem = 0; // make mem become 0 because tmp <= 9
					tmp2 = tmp;
				}
				
				//Send message
				msg = "Step " + B + ": " + x + " + " + y + " = "
                    + (x + y) + " + " + mem + " = " + tmp2 + " . Write " + tmp + " remember " + mem;
				this.ireceiver.send(msg);
				B++; //increase step
				
				result = tmp + result; // Sum 								
			}
			
			if(mem == 1){ // when we run all length and we still have mem = 1 , so we write 1 at first of result
				result = 1 + result;
				msg = "Step " + B + ": Write down 1 and result is " + result; 
				this.ireceiver.send(msg);
			}
			
			return result;
	}
	//Just a method to convert char into number//
	public static int Convert(char x){
		return (x - '0');
	}
}