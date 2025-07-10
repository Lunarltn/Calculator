package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    // 연산 결과 저장
    private static List<Number> results = new ArrayList<>();

    public List<Number> getResults() {
        return results;
    }

    public void setResults(List<Number> results) {
        this.results = results;
    }

    public Number calculate(T n, T m, OperatorType o) throws ArithmeticException {
        double result = calculate(n.doubleValue(), m.doubleValue(), o);

        if (result % 1 == 0) {
            results.add((int) result);
            return (int) result;
        }
        results.add(result);
        return result;

    }

    double calculate(double n, double m, OperatorType o) throws ArithmeticException {
        return switch (o) {
            case SUM -> n + m;
            case SUB -> n - m;
            case MUL -> n * m;
            case DIV -> {
                if (m == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                yield n / m;
            }
        };
    }

    public void removeResult() {
        results.remove(0);
    }

}
