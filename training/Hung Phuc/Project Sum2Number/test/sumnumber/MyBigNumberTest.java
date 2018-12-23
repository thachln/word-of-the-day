package sumnumber;


import org.junit.Test;
import static org.junit.Assert.*;
import sun.reflect.generics.repository.ConstructorRepository;

/**
 *
 * @author Phuc Nguyen
 */


public class MyBigNumberTest implements IReceiver{
    
    @Test
    ////string 1 length equal string 2 length
    public void testSum_N_1() {
        System.out.println("Test1");
        String s1 = "123";
        String s2 = "123";
        MyBigNumber instance;
        instance = new MyBigNumber(this);
        String expResult = "246";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
    
    ////string 1 length larger than string 2 length
    @Test
    public void testSum_N_2() {
        System.out.println("Test2");
        String s1 = "12345";
        String s2 = "1";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "12346";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
    ////string 1 length shorter than string 2 length
    @Test
    public void testSum_N_3() {
        System.out.println("Test3");
        String s1 = "1";
        String s2 = "1234567";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "1234568";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
    ////sum and write mem 1 before result
    @Test
    public void testSum_N_4() {
        System.out.println("Test4");
        String s1 = "99";
        String s2 = "1";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "100";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
     ////string 1 empty
    @Test
    public void testSum_N_5() {
        System.out.println("Test5");
        String s1 = "";
        String s2 = "123";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "123";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
    ////string 2 empty
    @Test
    public void testSum_N_6() {
        System.out.println("Test6");
        String s1 = "1234";
        String s2 = "";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "1234";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
     ////both string empty
    @Test
    public void testSum_N_7() {
        System.out.println("Test7");
        String s1 = "";
        String s2 = "";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "0";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    
    ////Test when string1 input contain a letter char
    @Test(expected=NumberFormatException.class)
    public void testSum_N_8() {
        System.out.println("Test8");
        String s1 = "a12";
        String s2 = "1234";
        MyBigNumber instance = new MyBigNumber(this);
        String result = instance.sum(s1, s2);
    }
    
    ////Test when string2 input contain a letter char
    @Test(expected=NumberFormatException.class)
    public void testSum_N_9() {
        System.out.println("Test9");
        String s1 = "1234";
        String s2 = "a";
        MyBigNumber instance = new MyBigNumber(this);
        String result = instance.sum(s1, s2);
    }
    
    ////Test when string1 input contain special char
    @Test(expected=NumberFormatException.class)
    public void testSum_N_10() {
        System.out.println("Test10");
        String s1 = "!!12";
        String s2 = "1234";
        MyBigNumber instance = new MyBigNumber(this);
        String result = instance.sum(s1, s2);
    }
    
    ////Test when string1 input contain special char
    @Test(expected=NumberFormatException.class)
    public void testSum_N_11() {
        System.out.println("Test11");
        String s1 = "123";
        String s2 = "!!1";
        MyBigNumber instance = new MyBigNumber(this);
        String result = instance.sum(s1, s2);
    }
    
    @Override
	public void send(String msg) {
		// TODO Auto-generated method stub
	}


}
