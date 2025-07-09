package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 숫자를 입력하세요: ");
        int n = sc.nextInt();
        System.out.println("두 번째 숫자를 입력하세요: ");
        int m = sc.nextInt();
        System.out.println("사칙연산 기호를 입력하세요: ");
        char c = sc.next().charAt(0);

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
                    break;
                }
                result = n / m;
                break;
        }

        if (!(c == '/' && m == 0)) // 분모가 0인 나눗셈 처리
            System.out.println("결과: " + result);
    }
}
