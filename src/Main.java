import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 첫 번째 숫자 입력
            int num1 = inputNumber(sc, "첫 번째 숫자를 입력하세요: ");

            // 두 번째 숫자 입력
            int num2 = inputNumber(sc, "두 번째 숫자를 입력하세요: ");

            // 연산자 입력
            char operator = getOperator(sc);

            // 연산자에 맞는 연산 수행
            double result = 0.0;
            if (operator == '+') {
                result = add(num1, num2);
            } else if (operator == '-') {
                result = subtract(num1, num2);
            } else if (operator == '*') {
                result = multiply(num1, num2);
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue;
                } else {
                    result = (double) num1 / num2;
                }
            } else {
                System.out.println("올바른 연산자를 입력해주세요.");
                continue;
            }

            // 연산 결과 출력
            System.out.println("결과: " + result);

            // if 문을 도입하여 exit 입력 시 프로그램 종료
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String order = sc.nextLine();
            if (order.equals("exit")) {
                System.out.println("계산기를 종료합니다. 안녕히 가세요");
                break;
            }
        }
    }

    private static double divide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
        return (double) num1 / num2;
    }

    private static double multiply(int num1, int num2) {
        double result;
        result = num1 * num2;
        return result;
    }

    private static double subtract(int num1, int num2) {
        double result;
        result = num1 - num2;
        return result;
    }

    private static double add(int num1, int num2) {
        double result;
        result = num1 + num2;
        return result;
    }

    private static char getOperator(Scanner sc) {
        System.out.print("사칙연산 기호를 입력하세요(예: +,-,*,/) : ");
        return sc.nextLine().charAt(0);
    }

    private static int inputNumber(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int num = sc.nextInt();
                if (num < 0) {
                    System.out.println("0 이상의 정수만 입력 가능합니다.");
                    continue;
                }
                sc.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}