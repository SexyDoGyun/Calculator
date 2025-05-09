package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator();

        while (true) {
            // 첫 번째 숫자 입력 : 정수를 입력 받기 위한 스캐너 변수와 메시지를 매개변수로 받습니다.
            int num1 = inputNumber(sc, "첫 번째 숫자를 입력하세요: ");

            // 두 번째 숫자 입력
            int num2 = inputNumber(sc, "두 번째 숫자를 입력하세요: ");

            // 연산자 입력
            char operator = getOperator(sc);

            // 연산자에 맞는 연산 수행
            double result;
            try {
                result = calc.calculate(num1, num2, operator);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 연산 결과 출력
            System.out.println("결과: " + result);

            System.out.print("전체 결과를 확인하시겠습니까?(궁금하다면 yes를 입력해주세요): ");
            checkingResult(sc, calc);

            System.out.println("가장 오래된 결과를 삭제하시겠습니까?(삭제하고싶다면 del을 입력해주세요.): ");
            removeOldestResult(sc, calc);

            // if 문을 도입하여 exit 입력 시 프로그램 종료
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String order = sc.nextLine();
            if (order.equals("exit")) {
                System.out.println("계산기를 종료합니다. 안녕히 가세요");
                break;
            }
        }
    }

    private static void checkingResult(Scanner sc, Calculator calc) {
        String checkResult = sc.nextLine();
        if (checkResult.equals("yes")) {
            System.out.println("지금까지 계산한 결과: " + calc.getResults());
        }
    }

    private static void removeOldestResult(Scanner sc, Calculator calc) {
        String checkDel = sc.nextLine();
        if (checkDel.equals("del")) {
            calc.removeResult();
            System.out.print("현재 남아있는 결과값: " + calc.getResults());
            sc.nextLine();
        }
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