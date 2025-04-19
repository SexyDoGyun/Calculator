package lv3;

import java.util.function.DoubleBinaryOperator;

public enum OperatorType {
    ADD('+', (a,b) -> a+b),
    MINUS('-', (a,b) -> a-b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a,b) -> {
        if (b == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        } else {
            return a / b;
        }
    });

    private final char symbol;
    private final DoubleBinaryOperator operation;

    OperatorType(char symbol, DoubleBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double apply(double a, double b) {
        return operation.applyAsDouble(a, b);
    }

    public static OperatorType fromChar(char symbol) {
        for (OperatorType op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + symbol);
    }

    public char getSymbol() {
        return symbol;
    }


}
