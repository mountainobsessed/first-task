import java.util.Scanner;

/**
 * This program allows you to calculate both Arabic and Latin numbers
 * in the diapason from 1 to 10 inclusive.
 */

class Program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator<?> calculator;

        if (scanner.hasNextInt()){
            calculator = new ArabicCalculator();
        }
        else{
            calculator = new RomanCalculator();
        }

        calculator.calculate(scanner);
    }
}

