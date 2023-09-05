package pro.sky.calculator;

import org.junit.jupiter.api.Test;
import pro.sky.calculator.Exception.ZeroException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    CalculatorService service = new CalculatorService();

    @Test
    void testPlus() {
        var actual = service.plus(1d, 2d);
        assertEquals(3d, actual);
        var actual1 = service.plus(-1d, 2d);
        assertEquals(1d, actual1);
        var actual2 = service.plus(1d, -2d);
        assertEquals(-1d, actual2);
        var actual3 = service.plus(-1d, -2d);
        assertEquals(-3d, actual3);
    }
    @Test
    void testMinus() {
        var actual = service.minus(1d, 2d);
        assertEquals(-1d, actual);
        var actual1 = service.minus(-1d, 2d);
        assertEquals(-3d, actual1);
        var actual2 = service.minus(1d, -2d);
        assertEquals(3d, actual2);
        var actual3 = service.minus(-1d, -2d);
        assertEquals(1d, actual3);
    }
    @Test
    void testMultiply() {
        var actual = service.multiply(1d, 2d);
        assertEquals(2d, actual);
        var actual1 = service.multiply(-1d, 2d);
        assertEquals(-2d, actual1);
        var actual2 = service.multiply(1d, -2d);
        assertEquals(-2d, actual2);
        var actual3 = service.multiply(-1d, -2d);
        assertEquals(2d, actual3);
        var actual4 = service.multiply(0d, -2d);
        assertEquals(-0d, actual4);
        var actual5 = service.multiply(-1d, 0d);
        assertEquals(-0d, actual5);
    }
    @Test
    void testDivide() {
        var actual = service.divide(1d, 2d);
        assertEquals(0.5d, actual);
        var actual1 = service.divide(-1d, 2d);
        assertEquals(-0.5d, actual1);
        var actual2 = service.divide(6d, -2d);
        assertEquals(-3d, actual2);
        var actual3 = service.divide(-6d, -2d);
        assertEquals(3d, actual3);
        var actual4 = service.divide(0d, -2d);
        assertEquals(-0d, actual4);

        assertThrows(ZeroException.class, () -> service.divide(1d, 0d));
    }
}