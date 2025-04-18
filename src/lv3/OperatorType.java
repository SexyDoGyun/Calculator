package lv3;

public enum OperatorType {
    ADD('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char Symbol;

    OperatorType(char symbol) {
        Symbol = symbol;
    }
}
