package lv3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 계산 기능 객체 생성
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        // 계산 결과 저장 객체 생성
        ResultRepository<Number> calculateResult = new ResultRepository<>();
        // 부가 기능 객체 생성
        Options options = new Options(calculateResult);

        while (true) {
            // 숫자 2개 입력(정수 or 실수)
            Number num1 = Input.inputNumber("첫 번째 숫자를 입력하세요: ", sc);
            Number num2 = Input.inputNumber("두 번째 숫자를 입력하세요: ", sc);

            // 연산자 입력
            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/) : ");
            char op = sc.next().charAt(0);
            sc.nextLine();

            try {
                // 입력한 연산자를 기반으로 OperatorType enum으로 변환
                OperatorType operatorType = OperatorType.of(op);
                // 계산 수행
                Number result = calculator.calculate(num1, num2, operatorType);
                // 결과 저장
                calculateResult.save(result);
                System.out.println("계산 결과: " + result);
            } catch (Exception e) {
                // 던져진 예외 메시지 출력
                System.out.println(e.getMessage());
            }

            // 종료 및 부가기능 수행
            if (Command.process(options, sc)) break;
        }
    }


}
