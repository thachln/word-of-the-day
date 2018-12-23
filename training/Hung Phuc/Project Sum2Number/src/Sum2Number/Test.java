
package Sum2Number;

import java.util.*;

/**
 *
 * @author Phuc Nguyen
 * This file is using for user to enter 2 string from keyboard and see the step by step of sum method
 */

class Test implements IReceiver{
    public static void main(String[]args){	
        MyBigNumber mb = new MyBigNumber(new Test());
	Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number 1: ");
        String s1 = sc.nextLine();
        
        System.out.println("Enter number 2: ");
	String s2 = sc.nextLine();
	
        System.out.println("Result: "+ mb.Sum(s1,s2));
	}
	
    @Override
    public void send(String msg){
        System.out.println(msg);
    }
}