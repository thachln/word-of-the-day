package myjava.mybignumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBigNumberApplication implements IReceiver{

    public static void main(String[] args) {
        SpringApplication.run(MyBigNumberApplication.class, args);

        System.out.println("Final step: " +
                ( new MyBigNumber(
                        new MyBigNumberApplication())).
                        sum(args[0], args[1]));
    }

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}

