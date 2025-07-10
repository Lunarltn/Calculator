package com.example.calculator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("첫 번째 숫자를 입력하세요: ");
            Number n = safeNextNumber(sc);
            System.out.println("두 번째 숫자를 입력하세요: ");
            Number m = safeNextNumber(sc);
            System.out.println("사칙연산 기호를 입력하세요: ");
            OperatorType c = safeNextOperator(sc);

            try {
                Number result = calculator.calculate(n, m, c);
                System.out.println("결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        }
        while (!sc.next().equals("exit"));

        System.out.println("연산 된 결과값들: " + calculator.getResults());
        List<Number> results = calculator.getResults();
        results.add(1000);
        calculator.setResults(results);
        System.out.println("1000을 넣고 변경 된 결과값: " + calculator.getResults());
        calculator.removeResult();
        System.out.println("가장 먼저 저장된 데이터 삭제 후 변경 된 결과값: " + calculator.getResults());
    }

    public static Number safeNextNumber(Scanner sc) {
        while (true) {
            String input = sc.next();
            if (isInteger(input)) {
                return Integer.parseInt(input);
            } else if (isDouble(input)) {
                return Double.parseDouble(input);
            }
            System.out.println("[Error] 숫자를 입력해 주세요.");
            sc.nextLine();
        }
    }

    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static OperatorType safeNextOperator(Scanner sc) {
        while (true) {
            try {
                char c = sc.next().charAt(0);
                return OperatorType.getType(c);
            } catch (Exception e) {
                System.out.println("[Error] 올바른 사칙연산 기호를 입력해 주세요.");
                sc.nextLine();
            }
        }
    }
}
