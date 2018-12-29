package myjava.mybignumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tác giả: Nguyễn Châu Thảo Quân.
 * DesCription.
 * Class MyBigNumber là lớp để Cộng 2 số lớn bằng 2 chuỗi.
 * Hàm sum trong Class MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số
 */

public class MyBigNumber {

    private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }

    /**
     * Để thực hiện phép cộng, ta cần 2 chuỗi làm tham số cho hàm sum trong đó:
     * 2 chuỗi này đều chỉ chứa các kí số từ '0' đến '9'.
     * <br/>
     *
     * @param s1 chuỗi số thứ nhất.
     * @param s2 chuỗi số thứ hai.
     * @return chuỗi có giá trị là tổng của hai số s1 và s2.
     */

    public String sum(final String s1, final String s2) {
        // Xét giá trị null và khoảng trắng
        // Nếu 1 trong 2 tham số là null hoặc rỗng thì trả về tham số còn lại
        if ((s1 == null) && (s2 == null)) {

            return "0";
        } else if (s1 == null) {

            return s2;
        } else if (s2 == null) {

            return s1;
        }

        if ((s1.trim().isEmpty()) && (s2.trim().isEmpty())) {

            return "0";
        } else if (s1.trim().isEmpty()) {

            return s2;
        } else if (s2.trim().isEmpty()) {

            return s1;
        }

        // Phan khai bao
        String result = "";
        String msg = "";// Chuoi msg se lam tham so cho ham send cua interface IReceiver
        int length1 = s1.length();// do dai chuoi thu 1
        int length2 = s2.length();// do dai chuoi thu 2
        final int max = (length1 > length2) ? length1 : length2;// lay do dau lon nhat giua a va b
        int remember = 0;// Khởi tạo số nhớ = 0 để khi cộng sẽ có vài trường hợp lớn hơn 9
        int pos1 = 0;// Vị trí chuỗi s1
        int pos2 = 0;// Vị trí chuỗi s2
        char c1;// kí tự c1 dùng để lấy kí tự cuối cùng của chuỗi s1
        char c2;// kí tự c2 dùng để lấy kí tự cuối cùng của chuỗi s2
        int sum = 0;// Khởi tạo biến tổng = 0 để cộng 2 kí tự cuối cùng lại với nhau
        // Dùng Matcher kết hợp với pattern để tìm các kí tự đặc biết trong 2 chuỗi
        Pattern pattern = Pattern.compile("[:/!@#$%&*^()_+=|<>?{}\\\\[\\\\]~-]");
        final Matcher matcher1 = pattern.matcher(s1);
        final Matcher matcher2 = pattern.matcher(s2);
        final String nullStr = "null";// Khởi tạo chuỗi chứa chuỗi null

        // Kiểm tra chuỗi null của 2 tham số
        if ((s1.trim().equalsIgnoreCase(nullStr)) && (s2.trim().equalsIgnoreCase(nullStr))) {

            return "0";
        } else if (s1.trim().equalsIgnoreCase(nullStr)) {

            return s2;
        } else if (s2.trim().equalsIgnoreCase(nullStr)) {

            return s1;
        }

        // Kiểm tra số âm
        if (s1.charAt(0) == '-') {
            throw new NumberFormatException("Not support the negative number s1: " + s1);
        }

        if (s2.charAt(0) == '-') {
            throw new NumberFormatException("Not support the negative number s2: " + s2);
        }

        // Kiểm tra chữ trong chuỗi s1 và chuỗi s2
        for (int i = 0; i < length1; i++) {
            if (Character.isLetter(s1.charAt(i))) {
                throw new NumberFormatException("The error of position of s1 "
                        + (i + 1) + ": " + s1.charAt(i));
            }

            for (int j = 0; j < length2; j++) {
                if (Character.isLetter(s2.charAt(j))) {
                    throw new NumberFormatException("The error of position of s2 "
                            + (j + 1) + ": " + s2.charAt(j));
                }
            }
        }

        // Nếu hàm matcher.find() là đúng tức là trong chuỗi s1 có kí tự đặc biệt
        if (matcher1.find()) {
            throw new NumberFormatException("Position " + (matcher1.start() + 1) + " of string " + s1
                    + " is not a number");
        }

        if (matcher2.find()) {
            throw new NumberFormatException("Position " + (matcher2.start() + 1) + " of string " + s2
                    + " is not a number");
        }

        for (int i = 0; i < max; i++) {
            pos1 = length1 - i - 1;// cập nhật lại vị trí chuỗi s1
            pos2 = length2 - i - 1;// cập nhật lại vị trí chuỗi s2

            // Xét vị trí của 2 chuỗi xem có >= 0 hay không
            c1 = (pos1 >= 0) ? s1.charAt(length1 - i - 1) : '0';
            c2 = (pos2 >= 0) ? s2.charAt(length2 - i - 1) : '0';

            sum = (c1 - '0') + (c2 - '0') + remember;// chuyển kí tự thành số xong cộng cho số nhớ
            result = (sum % 10) + result;// Lấy kết quả tổng ở trên chia lấy dư cho 10 và ghép vào chuỗi kết quả
            remember = sum / 10;// Cập nhật lại số nhớ

            msg = "Step " + (i + 1) + ": " + c1 + " + " + c2 + " = "
                    + sum + " . Write " + (sum % 10) + " remember " + remember + ". Current Result: " + result;
            this.ireceiver.send(msg);
        }

        if (remember > 0) {
            result = remember + result;// Nếu số nhớ còn dư thì ghép vào chuỗi kết quả
            this.ireceiver.send("1 + 0 = 1. Current result: " + result);

        }

        return result;// Trả về kết quả thu được
    }

}
