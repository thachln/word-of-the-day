import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tác giả: Nguyễn Châu Thảo Quân.
 * DesCription.
 * Class MyBigNumberTest là lớp để kiểm tra xem kết quả có đúng hay không.
 * Các hàm dưới @Test được dùng để kiểm tra kết quả.
 */

public class MyBigNumberTest {


    @Test
    public void testSum() {
        MyBigNumber mb = new MyBigNumber();
        String sum = mb.sum("123", "4");

        // Kiem tra ket qua
        assertEquals("Correct!", "127", sum);
    }

    @Test
    public void testSum_N_1() {
        MyBigNumber mb = new MyBigNumber();
        String sum = mb.sum("123", "7");

        // Kiem tra ket qua
        assertEquals("Correct!", "130", sum);
    }

    @Test
    public void testSum_N_2() {
        MyBigNumber mb = new MyBigNumber();
        String sum = mb.sum("123", "987");

        // Kiem tra ket qua
        assertEquals("Correct!", "1110", sum);
    }
}
