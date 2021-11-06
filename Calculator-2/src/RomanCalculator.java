import java.util.Arrays;
import java.util.Scanner;

class RomanCalculator extends Calculator<String> {

    private static int toArabic(String roman) {

        int[] intervals = {0, 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] numerals = {"", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int result = 0;

        for (int i = intervals.length-1; i >= 0; i-- ) {
            while (roman.indexOf(numerals[i]) == 0 && numerals[i].length() > 0) {
                result += intervals[i];
                roman = roman.substring(numerals[i].length());
            }
        } return result;
    }

    private static String toRoman(int number)
    {
        if (number == 0){
            return "0";
        }

        Integer[] romanValueList = new Integer[] {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String[] romanCharList = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        StringBuilder result = new StringBuilder();

        if (number < 0){
            System.out.println("В римской СС нет отрицательных чисел");
        }

        for (int i = 0; i < romanValueList.length; i++)
        {
            while(number >= romanValueList[i])
            {
                number -= romanValueList[i];
                result.append(romanCharList[i]);
            }
        }
        return result.toString();
    }

    @Override
    String getNumber(Scanner scanner) {
        String[] allNumbers = new String[] {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };
        if (scanner.hasNext()) {
            String romans = scanner.next();

            if (!Arrays.stream(allNumbers).toList().contains(romans)) {
                System.out.println("Вы допустили ошибку при вводе числа в римском формате. Попробуйте еще раз.");
                return getNumber(scanner);
            }
            else
            {
                return romans;
            }
        }
        else{
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            return getNumber(scanner);
        }
    }

    @Override
    String plus(String first, String second) {
        int firstArabic = toArabic(first);
        int secondArabic = toArabic(second);
        int result = firstArabic + secondArabic;
        return toRoman(result);
    }

    @Override
    String minus(String first, String second) {
        int firstArabic = toArabic(first);
        int secondArabic = toArabic(second);
        int result = firstArabic - secondArabic;
        return toRoman(result);
    }

    @Override
    String multiply(String first, String second) {
        int firstArabic = toArabic(first);
        int secondArabic = toArabic(second);
        int result = firstArabic * secondArabic;
        return toRoman(result);
    }

    @Override
    String divide(String first, String second) {
        int firstArabic = toArabic(first);
        int secondArabic = toArabic(second);
        int result = firstArabic / secondArabic;
        return toRoman(result);
    }
}