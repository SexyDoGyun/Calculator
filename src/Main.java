import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num1 = 0;
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                try {
                    num1 = sc.nextInt();
                    if (num1 < 0) {
                        System.out.println("0 이상의 정수만 입력 가능합니다.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    sc.nextLine();
                }
            }

            int num2 = 0;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                try {
                    num2 = sc.nextInt();
                    if (num2 < 0) {
                        System.out.println("0 이상의 정수만 입력 가능합니다.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    sc.nextLine();
                }
            }
            sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요(예: +,-,*,/) : ");
            char operator = sc.nextLine().charAt(0);


            double result = 0.0;
            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue;
                } else {
                    result = (double) num1 / num2;
                }
            } else {
                System.out.println("올바른 연산자를 입력해주세요.");
            }
            System.out.println("결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String order = sc.nextLine();
            if (order.equals("exit")) {
                System.out.println("계산기를 종료합니다. 안녕히 가세요");
                break;
            }
        }
    }
}