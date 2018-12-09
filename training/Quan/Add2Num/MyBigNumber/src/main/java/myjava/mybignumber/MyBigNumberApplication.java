package myjava.mybignumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBigNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBigNumberApplication.class, args);
		
		MyBigNumber mb = new MyBigNumber();
		
		String sum = mb.sum(args[0], args[1]);
		
		System.out.println(sum);
	}
}
