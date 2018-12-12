import java.util.ArrayList;

public class Test implements IReceiver{

    public static void main(String[] args) {
        MyBigNumber mb = new MyBigNumber(new Test());
        System.out.println(mb.sum("1","9"));
    }

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
