package Sum2Number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Phuc Nguyen
 * @param s1 is first string
 * @param s2 is second string
 * @return value in String by plus s1 and s2
 */



public class MyBigNumber {
    
    private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
		
        this.ireceiver = ireceiver;
    }

    public String Sum(final String s1,final String s2) {
			
	int len1 = s1.length(); 
	int len2 = s2.length();
	int maxLen = Math.max(len1,len2);
	char c1; //to save char of digit of s1
	char c2; //to save char of digit of s2
	int d1; //value of c1 in integer
	int d2; //value of c2 in integer			
	int tmp; //to save sum of d1 and d2
	int resultTemp; //to save value of tmp after 
	int mem = 0; // to save
	String finalResult = ""; //final result
	int Step = 1; //to save how many step we use
	String msg = ""; //to print message 
						
	////////Code to check user input
				
	////Check if user enter negative number  
	for (int i = 0; i < len1; i++) {
            if (Character.isLetter(s1.charAt(i))) {
		throw new NumberFormatException("Position " + (i + 1) + " in String " + s1
                + " not a number");
            }
	}

	for (int i = 0; i < len2; i++) {
            if (Character.isLetter(s2.charAt(i))) {
		throw new NumberFormatException("Position" + (i + 1) + " in String " + s2
                + " not a number");
            }
	}
			
	////Check if user enter special char
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
			
	////Check user input empty string
	if (s1.isEmpty() && !s2.isEmpty()) {			
            return s2;
	}
	if (!s1.isEmpty() && s2.isEmpty()) {
            return s1;
	}
	if (s1.isEmpty() && s2.isEmpty()) {			
            return "0";
	}
			
	////////This Code for sum			
			
	////We loop maxLen times
	for (int i = 0; i < maxLen; i++) {
            int index1 = len1 - i - 1; //to choose what char index in s1 we will take
            int index2 = len2 - i - 1; //to choose what char index in s2 we will take
				
            c1 = (index1 >= 0) ? s1.charAt(index1) : '0';
            c2 = (index2 >= 0) ? s2.charAt(index2) : '0';
							
            d1 = c1 - '0'; //convert c1 into integer number
            d2 = c2 - '0'; //convert c1 into integer number
				
            tmp = d1 + d2 + mem;
				
            finalResult = (tmp % 10) + finalResult; // plus with finalResult by add it before finalResult 
            
            msg = "Step " + Step + ": " + d1 + " + " + d2 + " = " + (d1 + d2) + " + " 
		+ mem + " = " + tmp + " . Write " + (tmp % 10) + " remember " + (mem / 10);
		this.ireceiver.send(msg);
            
            Step ++; //increase step
            
            mem = tmp / 10; // Change mem
	}
			
	//// when we run all length and we still have mem = 1 , so we write 1 at first of result
	if (mem == 1) { 
            finalResult = 1 + finalResult;
            
            msg = "Step " + Step + ": Write down 1 and result is " + finalResult; 
            this.ireceiver.send(msg);
	}
			
	return finalResult;
    }
    
}
