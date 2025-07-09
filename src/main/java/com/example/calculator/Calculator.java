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

    }
}
