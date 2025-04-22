package lv3;


public class ArithmeticCalculator<T extends Number> {

    public double calculate(T num1, T num2, OperatorType op) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();

        return op.calculate(a, b);
    }

}
