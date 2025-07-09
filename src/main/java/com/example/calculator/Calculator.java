package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과 저장
    List<Integer> results = new ArrayList<Integer>();

    public int calculate(int n, int m, char c) {
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
                if (m == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                    return 0;
                }
                result = n / m;
                break;
        }

        results.add(result);

        return result;
    }
}
