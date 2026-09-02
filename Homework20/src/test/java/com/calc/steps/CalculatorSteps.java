package com.calc.steps;


import com.calc.context.CalculatorScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import com.calc.Calculator;
import org.junit.jupiter.api.Assertions;

public class CalculatorSteps {
    Calculator calculator = new Calculator();
    CalculatorScenarioContext context = new CalculatorScenarioContext();

    @When("я складываю числа {double} и {double} на калькуляторе и сохраняю результат в переменную {string}")
    public void addNumbers(double a, double b, String varName) {
        double result = calculator.add(a, b);
        context.putVariable(varName, result);
    }

    @When("я вычитаю из числа {double} число {double} на калькуляторе и сохраняю результат в переменную {string}")
    public void subtractNumbers(double a, double b, String varName) {
        double result = calculator.subtract(a, b);
        context.putVariable(varName, result);
    }

    @When("я умножаю числа {double} и {double} на калькуляторе и сохраняю результат в переменную {string}")
    public void multiplyNumbers(double a, double b, String varName) {
        double result = calculator.multiply(a, b);
        context.putVariable(varName, result);
        Allure.addAttachment("Результат метода умножения в калькуляторе", "text/plain", a + " x " + b + " = " + result);
    }

    @When("я делю число {double} на {double} на калькуляторе и сохраняю результат в переменную {string}")
    public void divideNumbers(double a, double b, String varName) {
        try {
            double result = calculator.divide(a, b);
            context.putVariable(varName, result);
        }
        catch (Exception e) {
            context.setException(e);
        }
    }

    @When("я возвожу число {double} в степень {double} на калькуляторе и сохраняю результат в переменную {string}")
    public void powerNumbers(double a, double b, String varName) {
        double result = calculator.power(a, b);
        context.putVariable(varName, result);
    }

    @When("я извлекаю квадратный корень из числа {double} на калькуляторе и сохраняю результат в переменную {string}")
    public void powerNumbers(double a, String varName) {
        Allure.step("Попытка извлечь корень из числа", () -> {
            try {
                double result = calculator.sqrt(a);
                context.putVariable(varName, result);
            }
            catch (Exception e) {
                context.setException(e);
            }
        });
    }

    @Then("я ожидаю, что значение переменной {string} равно {double}")
    public void addNumbers(String varName, double expResult) {
        double result = context.getVariable(varName);
        Assertions.assertEquals(expResult, result);
    }

    @Then("я ожидаю, что выброшено исключение {string}")
    public void expectException(String exceptionName) {
        Assertions.assertEquals(exceptionName ,context.getException().getClass().getSimpleName());
    }

    @Then("я ожидаю, что текст исключения содержит {string}")
    public void expectExceptionMessage(String message) {
        Assertions.assertTrue(context.getException().getMessage().contains(message));
    }
}
