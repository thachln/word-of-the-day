package myjava.mybignumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBigNumberApplication implements IReceiver {

	public static void main(String[] args) {
//		SpringApplication.run(MyBigNumberApplication.class, args);
		
		MyBigNumberApplication app = new MyBigNumberApplication();
		MyBigNumber mb = new MyBigNumber(app);
		
		String sum = mb.sum(args[0], args[1]);
		
		System.out.println("Final step: " + sum);
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
}
