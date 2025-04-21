package lv3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        ResultRepository<Number> calculateResult = new ResultRepository<>();
        Options options = new Options(calculateResult);

        while (true) {
            // 첫 번째 숫자 입력 : 정수를 입력 받기 위한 스캐너 변수와 메시지를 매개변수로 받습니다.
            Number num1 = inputNumber("첫 번째 숫자를 입력하세요: ", sc);
            // 두 번째 숫자 입력
            Number num2 = inputNumber("두 번째 숫자를 입력하세요: ", sc);

            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/) : ");
            char op = sc.next().charAt(0);
            sc.nextLine();

            try {
                OperatorType operatorType = OperatorType.of(op);
                Number result = calculator.calculate(num1, num2, operatorType);
                calculateResult.save(result);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // if 문을 도입하여 exit 입력 시 프로그램 종료
            if (options(sc, options)) break;
        }
    }

    private static boolean options(Scanner sc, Options manager) {
        System.out.println("더 계산할건가요?");
        System.out.println("기능 : [exit : 종료, show : 결과 확인, del : 결과 삭제, big : 특정 값 보다 큰 값 조회]");
        // order에 대문자, 소문자, 빈 값이 들어올 수 있으므로 받아올 때 toLowerCase().trim()를 통해 소문자로 변환시키고, 양쪽에 빈 값을 없앤다.
        String order = sc.nextLine().toLowerCase().trim();
        if (order.equals("exit")) {
            System.out.println("계산기를 종료합니다. 안녕히 가세요");
            return true;
        } else if (order.equals("show")) {
            manager.showResult();
        } else if (order.equals("del")) {
            manager.deleteOldest();
        } else if (order.equals("big")) {
            System.out.print("비교하고 싶은 값을 입력해주세요: ");
            double compareNum = sc.nextDouble();
            manager.showBigger(compareNum);
            sc.nextLine();
        } else {
            System.out.println("올바른 명령어가 아닙니다. 다시 입력해주세요.");
        }
        return false;
    }

    private static Number inputNumber(String message, Scanner sc) {
        while (true) {
            System.out.print(message);
            String inputNum = sc.nextLine();
            try {
                if (inputNum.contains(".")) {
                    return Double.parseDouble(inputNum);
                } else {
                    return Integer.parseInt(inputNum);
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
    }
}
