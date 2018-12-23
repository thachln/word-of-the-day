package sumnumber;

/**
 *
 * @author PhucNguyen
 */
class TimeRun implements IReceiver{
    public static void main(String[]args) {
        MyBigNumber mb = new MyBigNumber(new TimeRun());
        String s1 = "";
        String s2 = "";
        
        //// By loop 10 time , we create two string contain 100 character
        for(int i = 0; i < 10; i++) {
            s1 = s1 + "1234567892";
            s2 = s2 + "9876545231";
        }
        
        long startTime = System.currentTimeMillis();
        String result = mb.sum(s1,s2);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        System.out.println(result);
        System.out.println("Total time run : " + totalTime + " millisecond");
    }
    @Override
    public void send(String msg){
        System.out.println(msg);
    }
}
