import org.junit.jupiter.api.*;

public class MethodTest {
    private Method method;

    @BeforeEach
    void init() {
        method = new Method();
    }

    //тесты первого метода
    @Test
    void changeArray1() {
        Assertions.assertThrows(RuntimeException.class, () -> method.changeArray(new int[]{1, 2}));
    }

    @Test
    void changeArray2() {
        Assertions.assertArrayEquals(new int[]{5, 6}, method.changeArray(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    void changeArray3() {
        Assertions.assertArrayEquals(new int[]{}, method.changeArray(new int[]{1, 2, 3, 4}));
    }

    @Test
    void changeArray4() {
        Assertions.assertArrayEquals(new int[]{5, 6}, method.changeArray(new int[]{4, 4, 4, 4, 5, 6}));
    }

    //тесты второго метода
    @Test
    void checkArray1() {
        Assertions.assertTrue(method.checkArray(new int[]{1, 1, 1, 4, 4, 4}));
    }

    @Test
    void checkArray2() {
        Assertions.assertFalse(method.checkArray(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    void checkArray3() {
        Assertions.assertFalse(method.checkArray(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test
    void checkArray4() {
        Assertions.assertFalse(method.checkArray(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
