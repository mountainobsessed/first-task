import java.util.Arrays;
import java.util.Scanner;

abstract class Calculator<T> {
    public void calculate(Scanner scanner){
        T firstNumber = getNumber(scanner);
        String operator = getOperator(scanner);
        T secondNumber = getNumber(scanner);

        T result;
        switch (operator) {
            case "+" -> result = plus(firstNumber, secondNumber);
            case "-" -> result = minus(firstNumber, secondNumber);
            case "*" -> result = multiply(firstNumber, secondNumber);
            case "/" -> result = divide(firstNumber, secondNumber);
            default -> throw new IllegalStateException(operator);
        }
        System.out.println("Результат: " + result.toString());
    }

    String getOperator(Scanner scanner){
        String[] operators = new String[]{
                "+", "-", "*", "/"
        };
        String signs = scanner.next();
        if (!Arrays.stream(operators).toList().contains(signs))
        {
            System.out.println("Вы допустили ошибку при вводе оператора. Попробуйте еще раз.");
            return ("Одно из четырех действий допустимо: +, -, *, /");
        }
        else
        {
            return signs;
        }
    }


    abstract T getNumber(Scanner scanner);
    abstract T plus(T first, T second);
    abstract T minus(T first, T second);
    abstract T multiply(T first, T second);
    abstract T divide(T first, T second);
}