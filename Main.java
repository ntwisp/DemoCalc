import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String input = scan.nextLine();
        scan.close();
        try {
            String res = calc(input);
            System.out.println("Результат = " + res);
        } catch (Exception e) {
            System.out.println("Ошибка: " +e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] line = input.split(" ");
        if (line.length != 3) {
            throw new Exception("Неверный формат, используйте два целых числа до 10 и один оператор через пробел.");
        }
        int a = number(line[0]);
        String op = (line[1]);
        int b = number(line[2]);
        int res = switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new Exception("Деление на 0 невозможно");
                }
                yield a / b;
            }
            default -> throw new Exception("4 знаков мало?");
        };
        return String.valueOf(res);
    }

     static int number(String s) throws Exception {
        try {
            int number = Integer.parseInt(s);
            if (number < 1 || number > 10) {
                throw new Exception("Целые числа от 1 до 10");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Только числа");
        }
    }
}
// ntwisp