package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private final List<Double> results = new ArrayList<>();


    public double calculate(T num1, T num2, OperatorType operatorType) {
        double result = operatorType.apply(num1.doubleValue(), num2.doubleValue());
        results.add(result);
        return result;
    }

    public List<Double> getResults() {
        return results;
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(result -> result > threshold)
                .collect(Collectors.toList());
    }
}
