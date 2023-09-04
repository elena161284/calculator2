package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plus(double num1, double num2) {
        return (int) (num1 + num2);
    }

    public double minus(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    public double divide(double num1, double num2) {
        return (double) num1 / num2;
    }
}