package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @GetMapping
    public String calculator() {
        return "/calculator";
    }

    @PostMapping
    public String calculate(@RequestParam(name = "firstN") double firstN,
                            @RequestParam(name = "secondN") double secondN,
                            @RequestParam(name = "calculate") String calculate,
                            Model model) {
        double result;
        switch (calculate) {
            case "+":
                result = firstN + secondN;
                break;
            case "-":
                result = firstN - secondN;
                break;
            case "*":
                result = firstN * secondN;
                break;
            case "/":
                if (secondN == 0) {
                    throw new ArithmeticException("Can't divide by zero.");
                } else {
                    result = firstN / secondN;
                }
                break;
            default:
                throw new UnsupportedOperationException("Calculations are not supported.");
        }
        model.addAttribute("result", result);
        return "/calculator";
    }
}