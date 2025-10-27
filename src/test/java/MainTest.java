import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.thi.utility.MathFunction;

public class MainTest {
    @Test
    void testBienMax() {
        assertEquals(250000, MathFunction.tongSoLe());
    }

    @Test
    void testOnDinh() {
        int result1 = MathFunction.tongSoLe();
        int result2 = MathFunction.tongSoLe();
        assertEquals(result1, result2);
    }

    @Test
    void testKhongAm() {
        assertEquals(MathFunction.tongSoLe() >= 0, true);
    }

    @Test
    void testVuotQuaMax() {
        assertEquals(MathFunction.tongSoLe() < Integer.MAX_VALUE, true);
    }

    @Test
    void testKhacKhong() {
        assertEquals(MathFunction.tongSoLe() != 0, true);
    }

}
