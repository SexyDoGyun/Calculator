package lv3;

import java.util.function.DoubleBinaryOperator;

public enum OperatorType {
    ADD('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        } else {
            return a / b;
        }
    });

    private final char operator;
    private final DoubleBinaryOperator operation;

    OperatorType(char operator, DoubleBinaryOperator operation) {
        this.operator = operator;
        this.operation = operation;
    }


    public char getOperator() {
        return operator;
    }

    public static OperatorType of(char op) {
        if (op == '+') {
            return ADD;
        } else if (op == '-') {
            return MINUS;
        } else if (op == '*') {
            return MULTIPLY;
        } else if (op == '/') {
            return DIVIDE;
        } else {
            throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + op);
        }
    }

    public double calculate(double a, double b) {
        return operation.applyAsDouble(a, b);
    }

}

