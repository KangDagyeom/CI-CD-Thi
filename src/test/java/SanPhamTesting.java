import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.thi.entity.SanPham;
import com.example.thi.service.SanPhamServ;

public class SanPhamTesting {

    private SanPhamServ phamServ;

    @BeforeEach
    void setUp() {
        phamServ = new SanPhamServ();
        SanPham stub = new SanPham("Banh keo", 10.000F, "SP01", 1, 10, "Oreo");
        phamServ.add(stub);
    }

    private SanPham sanPham;

    @Test
    void testAddHopLe() {
        sanPham = new SanPham("Kem", 13.000F, "SP02", 2, 3, "Kem cheese");
        phamServ.add(sanPham);
        List<SanPham> list = phamServ.getAll();
        assertTrue(list.contains(sanPham), "Danh sach phai duoc them 1 san pham");
    }

    @Test
    void testIDTrung() {
        sanPham = new SanPham("Kem", 13.000F, "SP01", 2, 3, "Kem cheese");
        assertThrows(IllegalArgumentException.class, () -> phamServ.add(sanPham));
    }

    @Test
    void testSoLuongMax() {
        sanPham = new SanPham("Kem", 13.000F, "SP02", 2, 100, "Kem cheese");
        phamServ.add(sanPham);
        SanPham sanPhamVuaAdd = phamServ.findByID(sanPham.getMa());
        assertEquals("SP02", sanPhamVuaAdd.getMa());
    }

    @Test
    void testSoLuongMin() {
        sanPham = new SanPham("Kem", 13.000F, "SP02", 2, 1, "Kem cheese");
        phamServ.add(sanPham);
        SanPham sanPhamVuaAdd = phamServ.findByID(sanPham.getMa());
        assertEquals("SP02", sanPhamVuaAdd.getMa());
    }

    @Test
    void testSoLuongVuotBienMin() {

        sanPham = new SanPham("Kem", 13.000F, "SP02", 2, 0, "Kem cheese");
        assertThrows(IllegalArgumentException.class, () -> phamServ.add(sanPham));

    }

    @Test
    void testSoLuongVuotBienMax() {

        sanPham = new SanPham("Kem", 13.000F, "SP02", 2, 101, "Kem cheese");
        assertThrows(IllegalArgumentException.class, () -> phamServ.add(sanPham));

    }
}
