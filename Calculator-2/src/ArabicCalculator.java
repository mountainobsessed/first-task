import java.util.Arrays;
import java.util.Scanner;

class ArabicCalculator extends Calculator<Integer> {
    @Override
    Integer getNumber(Scanner scanner) {
        Integer[] allNumbs = new Integer[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        if (scanner.hasNextInt()) {
            Integer arabic = scanner.nextInt();
            if (!Arrays.stream(allNumbs).toList().contains(arabic)) {
                System.out.println("Калькулятор работает с числами от 1 до 10 включительно. Попробуйте еще раз.");
            } else {
                return arabic;
            }
        }
        return (0);
    }

    @Override
    Integer plus(Integer first, Integer second) {
        return first + second;
    }

    @Override
    Integer minus(Integer first, Integer second) {
        return first - second;
    }

    @Override
    Integer multiply(Integer first, Integer second) {
        return first * second;
    }

    @Override
    Integer divide(Integer first, Integer second) {
        return first / second;
    }
}