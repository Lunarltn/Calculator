package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("첫 번째 숫자를 입력하세요: ");
            int n = sc.nextInt();
            System.out.println("두 번째 숫자를 입력하세요: ");
            int m = sc.nextInt();
            System.out.println("사칙연산 기호를 입력하세요: ");
            char c = sc.next().charAt(0);
            int result = calculator.calculate(n, m, c);
            if (!(c == '/' && m == 0))
                System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        }
        while (!sc.next().equals("exit"));
    }

}
