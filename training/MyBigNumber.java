/**
 * Tác giả: Nguyễn Châu Thảo Quân.
 * DesCription.
 * Class MyBigNumber là lớp để Cộng 2 số lớn bằng 2 chuỗi.
 * Hàm sum trong Class MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số
 */

public class MyBigNumber {

    /**
     * Để thực hiện phép cộng, ta cần 2 chuỗi làm tham số cho hàm sum trong đó:
     * 2 chuỗi này đều chỉ chứa các kí số từ '0' đến '9'.
     * <br/>
     * @param s1 chuỗi số thứ nhất.
     * @param s2 chuỗi số thứ hai.
     * @return chuỗi có giá trị là tổng của hai số s1 và s2.
     */
    public String sum(final String s1, final String s2) {
        // Buoc 1: lay do dai 2 chuoi
        // Phan khai bao

        String result = "";
        int a = s1.length();// do dai chuoi thu 1
        int b = s2.length();// do dai chuoi thu 2
        int max = (a > b) ? a : b;// lay do dau lon nhat giua a va b
        int nho = 0;// Khởi tạo số nhớ = 0 để khi cộng sẽ có vài trường hợp lớn hơn 9
        int pos1 = 0;// Vị trí chuỗi s1
        int pos2 = 0;// Vị trí chuỗi s2
        char c1 = '0';// kí tự c1 dùng để lấy kí tự cuối cùng của chuỗi s1
        char c2 = '0';// kí tự c2 dùng để lấy kí tự cuối cùng của chuỗi s2
        int tong = 0;// Khởi tạo biến tổng = 0 để cộng 2 kí tự cuối cùng lại với nhau

        // Xét từng kí tự của 2 chuỗi
        for (int i = 0; (i < a) || (i < b); i++) {

            if (((s1.charAt(i) < 0) && (s1.charAt(i) > 9)) || ((s2.charAt(i) < 0) && (s2.charAt(i) > 9))) {
                throw new IllegalArgumentException("1 trong 2 chuoi nay khong phai la so nguyen hoan toan");
            }
        }

        // Lặp từ 0 đến max lần
        for (int i = 0; i < max; i++) {
            pos1 = a - i - 1;// cập nhật lại vị trí chuỗi s1
            pos2 = b - i - 1;// cập nhật lại vị trí chuỗi s2

            // Xét vị trí của 2 chuỗi xem có >= 0 hay không
            if ((pos1 >= 0) || (pos2 >= 0)) {
                c1 = s1.charAt(a - i - 1);
                c2 = s2.charAt(b - i - 1);
            }

            tong = (c1 - '0') + (c2 - '0') + nho;
            result = (tong % 10) + result;
            nho = tong / 10;
        }

        if (nho >= 1) {
            result = 1 + result;
        }

        return result;
    }
}
