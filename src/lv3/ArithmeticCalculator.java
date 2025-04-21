package lv3;


public class ArithmeticCalculator<T extends Number> {

    public Number calculate(T num1, T num2, OperatorType op) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();

        if (op == OperatorType.ADD) {
            return add(a, b);
        } else if (op == OperatorType.MINUS) {
            return minus(a, b);
        } else if (op == OperatorType.MULTIPLY) {
            return multiply(a, b);
        } else if (op == OperatorType.DIVIDE) {
            return divide(a, b);
        } else {
            throw new IllegalArgumentException("올바른 연산자를 입력해주세요.");
        }
    }

    private double add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    private double minus(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    private double multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    private double divide(Number a, Number b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        } else {
            return a.doubleValue() / b.doubleValue();
        }
    }


}
