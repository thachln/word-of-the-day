package myjava.mybignumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyBigNumberTest implements IReceiver{

    @Test
    public void testSum_N_1() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("", "123");

        assertEquals("123", sum);
    }

    @Test
    public void testSum_N_2() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("123", "");
        assertEquals("123", sum);
    }

    @Test
    public void testSum_N_3() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum(null,"1110");

        assertEquals("1110", sum);
    }

    @Test
    public void testSum_N_4() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("1110",null);

        assertEquals("1110", sum);
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_5() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("1a2", "123");
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_6() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("123", "1a2");
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_7() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("1123", "2^2");
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_8() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("2^2", "1123");
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_9() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("2-1", "2");
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_10() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("2", "2-1");
    }

    @Test
    public void testSum_N_11() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("1", "2");

        assertEquals("3", sum);
    }

    @Test
    public void testSum_N_12() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("2", "1");

        assertEquals("3", sum);
    }

    @Test
    public void testSum_N_13() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("2", "8");

        assertEquals("10", sum);
    }

    @Test
    public void testSum_N_14() {
        MyBigNumber mb = new MyBigNumber(this);
        String s = mb.sum("8", "2");
        assertEquals("10", s);
    }

    @Test
    public void testSum_N_15() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("12", "8");

        assertEquals("20", sum);
    }

    @Test
    public void testSum_N_16() {
        MyBigNumber mb = new MyBigNumber(this);
        String s = mb.sum("8", "12");
        assertEquals("20", s);
    }

    @Test
    public void testSum_N_17() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("123", "7");

        assertEquals("130", sum);
    }

    @Test
    public void testSum_N_18() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("7", "123");

        assertEquals("130", sum);
    }

    @Test
    public void testSum_N_19() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("123", "87");

        assertEquals("210", sum);
    }

    @Test
    public void testSum_N_20() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("87", "123");

        assertEquals("210", sum);
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_21() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("-87", "123");
    }

    @Test(expected = NumberFormatException.class)
    public void testSum_N_22() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("123","-87");
    }

    @Test
    public void testSum_N_23() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("", "");
        assertEquals("0", sum);
    }

    @Test
    public void testSum_N_24() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum(null, null);
        assertEquals("0", sum);
    }

    @Test
    public void testSum_N_25() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum(" ", " ");
        assertEquals("0", sum);
    }

    @Test
    public void testSum_N_26() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("null", "null");
        assertEquals("0", sum);
    }

    @Test
    public void testSum_N_27() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("123", "null");
        assertEquals("123", sum);
    }

    @Test
    public void testSum_N_28() {
        MyBigNumber mb = new MyBigNumber(this);
        String sum = mb.sum("null", "123");
        assertEquals("123", sum);
    }


    @Override
    public void send(String msg) {

    }
}