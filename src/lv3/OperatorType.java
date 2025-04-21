package lv3;

public enum OperatorType {
    ADD('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
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

}
