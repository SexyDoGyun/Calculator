package lv3;

import java.util.Scanner;

// 숫자 입력 받는 클래스 (정수 or 실수 판별 후 Number 타입으로 반환)
public class Input {
    public static Number inputNumber(String message, Scanner sc) {
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
