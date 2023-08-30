package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.Exception.NoArgumentSpecifiedException;
import pro.sky.calculator.Exception.ZeroException;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String hello() {
        return "<b>Добро пожаловать в калькулятор!<b>";
    }

    ///calculator/plus?num1=5&num2=5
    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " + " + num2 + " = " + service.plus(num1, num2);
    }
    ///calculator/minus?num1=5&num2=5
    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }
    ///calculator/multiply?num1=5&num2=5
    @GetMapping("/multiply")
    public String multiply(@RequestParam (required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NoArgumentSpecifiedException("один из оргументов не задан!");
        }
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }
    ///calculator/divide?num1=5&num2=5
    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            throw new ZeroException(" на 0 делить нельзя!");
        }
        return num1 + " : " + num2 + " = " + service.divide(num1, num2);
    }
}