import java.util.Scanner;
/**
 * Tác giả: Nguyễn Châu Thảo Quân.
 * DesCription.
 * Class Test là lớp để nhập 2 chuỗi s1 và s2 từ bàn phím.
 * Hàm main trong Class MyBigNumber là hàm để thực hiện phép nhập 2 chuỗi số.
 */

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1st String: ");
        String s1 = sc.nextLine();
        System.out.print("2nd String: ");
        String s2 = sc.nextLine();

        System.out.println((new MyBigNumber()).sum(s1,s2));


    }
}
