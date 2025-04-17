package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {


    // 가장 오래된 저장 값을 지운다 : 큐 (FIFO -> 먼저 들어온 사람이 먼저 나간다.)
    /**
     * Queue<Double> results = new LinkedList<>();
     * results.add(); -> 큐에 값을 삽입한다.
     * results.poll()(); -> 큐에 값을 제거한다. 큐가 공백이면 null 반환
     * results.size(); -> 큐의 크기를 반환한다.
     * results.isEmpty(); -> 큐가 비어있는지 확인한다.
     */
    private Queue<Double> results = new LinkedList<>();


    public double calculate(int num1, int num2, char operator) {
        double result;

        if (operator == '+') {
            result = add(num1, num2);
        } else if (operator == '-') {
            result = subtract(num1, num2);
        } else if (operator == '*') {
            result = multiply(num1, num2);
        } else if (operator == '/') {
            result = divide(num1, num2);
        } else {
            throw new IllegalArgumentException("올바른 연산자를 입력해주세요.");
        }

        results.add(result);
        return result;
    }

    private double divide(double num1, int num2) {
        double result;
        if (num2 == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        } else {
            result = num1 / num2;
        }
        return result;
    }

    public double add(int num1, int num2) {
        double result;
        result = num1 + num2;
        return result;
    }

    public double subtract(int num1, int num2) {
        double result;
        result = num1 - num2;
        return result;
    }

    public double multiply(int num1, int num2) {
        double result;
        result = num1 * num2;
        return result;
    }


}
