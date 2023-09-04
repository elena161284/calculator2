package pro.sky.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.Exception.NoArgumentSpecifiedException;
import pro.sky.calculator.Exception.ZeroException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceParameterTest {
    CalculatorService service = new CalculatorService();

    private static List<Arguments> parameters() {
        return List.of(
                Arguments.of(1, 2),
                Arguments.of(-1d, 2d),
                Arguments.of(-1d, -2d),
                Arguments.of(1d, -2d),
                Arguments.of(0d, 1d)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void test(double num1, double num2) {
        assertEquals(num1 + num2, service.plus(num1, num2));
        assertEquals(num1 - num2, service.minus(num1, num2));
        assertEquals(num1 * num2, service.multiply(num1, num2));
        assertEquals(num1 / num2, service.divide(num1, num2));

    }

    @Test
    void testZero() {
        assertThrows(ZeroException.class, () -> service.divide(1d, 0d));
    }
}