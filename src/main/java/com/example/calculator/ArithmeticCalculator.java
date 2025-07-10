package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    // 연산 결과 저장
    private List<Integer> results = new ArrayList<Integer>();

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public int calculate(int n, int m, char c) throws ArithmeticException {
        int result = 0;
        switch (c) {
            case '+':
                result = n + m;
                break;
            case '-':
                result = n - m;
                break;
            case '*':
                result = n * m;
                break;
            case '/':
                try {
                    result = n / m;
                } catch (ArithmeticException e) {
                    throw e;
                }
                break;
        }
        results.add(result);
        return result;
    }

    public void removeResult() {
        results.remove(0);
    }

}
