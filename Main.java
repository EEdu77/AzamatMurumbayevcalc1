import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");

        String input = scanner.nextLine().trim();

        try {
            System.out.println("Результат: " + calculate(input));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    public static int calculate(String input) throws Exception {

        input = input.replaceAll("\\s+", "");


        String[] parts = input.split("");

        if (parts.length != 3) {
            throw new Exception("Неправильный формат");
        }

        int a = parseNumber(parts[0]);
        int b = parseNumber(parts[2]);
        String operator = parts[1];

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль невозможно.");
                }
                return a / b;
            default:
                throw new Exception("Неподдерживаемая операция: " + operator);
        }
    }


    public static int parseNumber(String str) throws Exception {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new Exception("Некорректное число: " + str);
        }

        if (num < 1 || num > 10) {
            throw new Exception("Число вне диапазона (должно быть от 1 до 10): " + num);
        }

        return num;
    }
}
