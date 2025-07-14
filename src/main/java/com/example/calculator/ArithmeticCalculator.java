package com.example.calculator;

import com.example.enums.CalculationOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * 제네릭 기반의 사칙연산 계산기 클래스
 *
 * <p>타입 매개변수 {@code T}는 {@link Number}의 하위 타입이어야 하며,
 * {@code calculate()} 메서들르 통해 두 숫자에 대한 사칙연산을 수행한다.</p>
 *
 * <p>모든 연산 결과는 내부 {@link List}에 저장되며, {@code getResults()}를 통해 조회할 수 있다.</p>
 *
 * @param <T> 연산에 사용할 숫자 타입
 */
public class ArithmeticCalculator<T extends Number> {
    // 연산 결과가 저장된다.
    private List<Number> results = new ArrayList<>();

    // getter
    public List<Number> getResults() {
        return results;
    }

    // getter
    public void setResults(List<Number> results) {
        this.results = results;
    }

    /**
     * 주어진 두 숫자 {@code n}과 {@code m}에 대해 지정된 사칙 연산자 {@code o}를 적용하여 결과를 반환한다.
     * <p>지원하는 연산자는 +, -, *, /이며,
     * {@code T}는 {@link Number}를 상속한 타입이어야 한다.{Integer, Double 등}</p>
     *
     * @param n 첫 번째 피연산자({@link Number})
     * @param m 두 번째 피연산자({@link Number})
     * @param o 수행할 연산자(+, -, *, /)
     * @return 연산 결과를 {@link Number}로 반환
     * @throws ArithmeticException {@code o}가 나눗셈이고 {@code m}이 0인경우
     */
    public Number calculate(T n, T m, CalculationOperator o) throws ArithmeticException {
        double result = 0;
        if (n instanceof Integer && m instanceof Integer)
            result = calculate(n.intValue(), m.intValue(), o);
        else result = calculate(n.doubleValue(), m.doubleValue(), o);

        if (result % 1 == 0) {
            results.add((int) result);
            return (int) result;
        } else {
            results.add(result);
            return result;
        }
    }

    /**
     * 주어진 두 숫자 {@code n}과 {@code m}에 대해 지정된 사칙 연산자 {@code o}를 적용하여 결과를 반환한다.
     * <p>지원하는 연산자는 +, -, *, /이며, double을 피연산자로 받는다.</p>
     *
     * @param n 첫 번째 피연산자({@code double})
     * @param m 두 번째 피연산자({@code double})
     * @param o 수행할 연산자(+, -, *, /)
     * @return 연산 결과를 {@code double}로 반환
     * @throws ArithmeticException {@code o}가 나눗셈이고 {@code m}이 0인경우
     */
    double calculate(double n, double m, CalculationOperator o) throws ArithmeticException {
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

    /**
     * 주어진 두 숫자 {@code n}과 {@code m}에 대해 지정된 사칙 연산자 {@code o}를 적용하여 결과를 반환한다.
     * <p>지원하는 연산자는 +, -, *, /이며, int 피연산자로 받는다.</p>
     *
     * @param n 첫 번째 피연산자({@code int})
     * @param m 두 번째 피연산자({@code int})
     * @param o 수행할 연산자(+, -, *, /)
     * @return 연산 결과를 {@code int}로 반환
     * @throws ArithmeticException {@code o}가 나눗셈이고 {@code m}이 0인 경우
     */
    int calculate(int n, int m, CalculationOperator o) throws ArithmeticException {
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

    /**
     * 연산된 결과값을 저장하고 있는 {@code results}의 맨 앞 요소 제거
     */
    public void removeResult() {
        if (!results.isEmpty())
            results.remove(0);
    }
}
