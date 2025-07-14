package com.example.calculator;

import com.example.enums.CalculationOperator;
import com.example.enums.ComparionOperator;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 프로그램의 시작 클래스
 *
 * <p>이 클래스는 {@code main()} 메서드를 포함하며,
 * 사용자 입력을 받아 계산기를 실행하고 결과를 출력한 후,
 * 필터링 및 테스트 메서드를 차례로 수행합니다.</p>
 */
public class App {
    // 계산기 생성 -> 계산기 실행 -> 계산 결과 출력 -> 필터링 -> 테스트 순으로 실행된다     *
    public static void main(String[] args) {
        // 제네릭 숫자 계산기 생성
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

        // 계산기 실행
        runCalculator(calculator);

        // 모든 계산 결과 출력
        System.out.println("연산 된 결과값들: " + calculator.getResults());

        // 결과값에 대해 필터링 실행
        runFiltering(calculator.getResults());

        // 결과 리스트 getter/setter 테스트
        testGetSetOfCalculator(calculator);

        // 결과 리스트 삭제 기능 테스트
        testRemoveOfCalculator(calculator);
    }

    /**
     * 콘솔 입력을 통해 사용자로부터 두 숫자와 사칙 연산 기호를 입력받아 계산기를 실행한다.
     * <p>계산 결과를 콘솔에 출력하고, 사용자가 "exit"를 입력할 때까지 반복한다.</p>
     *
     * @param calculator 사칙 연산을 수행할 {@link ArithmeticCalculator}의 인스턴스
     */
    static void runCalculator(ArithmeticCalculator<Number> calculator) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("첫 번째 숫자를 입력하세요: ");
            Number n = safeNextNumber(sc);
            System.out.println("두 번째 숫자를 입력하세요: ");
            Number m = safeNextNumber(sc);
            System.out.println("사칙연산 기호를 입력하세요: ");
            CalculationOperator c = safeNextOperator(sc);

            try {
                Number result = calculator.calculate(n, m, c);
                System.out.println("결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        }
        while (!sc.next().equals("exit"));
    }

    /**
     * 콘솔 입력을 통해 사용자로부터 필터 조건을 입력받아 매개 변수로 받은 list를 필터링한다.
     * <p>필터 결과를 콘솔에 출력하고, 사용자가 "exit"를 입력할 때까지 반복한다.</p>
     *
     * @param list 필터링 할 {@link List}
     */
    static void runFiltering(List<Number> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("필터 조건을 입력해 주세요[예)> 4,<= 3]: ");
                String input = sc.nextLine();
                System.out.println("입력받은값:" + input);
                List<Number> filterResults = getFillteredList(list, input);
                System.out.println(input + " 조건에 맞는 결과값 \n" + filterResults);
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] 올바른 부호를 입력해 주세요.");
                continue;
            }
            System.out.println("더 조회 하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) break;
            sc.nextLine();
        }
    }

    /**
     * {@link ArithmeticCalculator} 클래스의 Getter Setter를 테스트한다.
     *
     * @param calculator {@link ArithmeticCalculator}의 인스턴스
     */
    static void testGetSetOfCalculator(ArithmeticCalculator<Number> calculator) {
        List<Number> results = calculator.getResults();
        results.add(1000);
        calculator.setResults(results);
        System.out.println("1000을 넣고 변경 된 결과값: " + calculator.getResults());
    }

    /**
     * {@link ArithmeticCalculator} 클래스의 {@code removeResult()}를 테스트한다.
     *
     * @param calculator {@link ArithmeticCalculator}의 인스턴스
     */
    static void testRemoveOfCalculator(ArithmeticCalculator<Number> calculator) {
        calculator.removeResult();
        System.out.println("가장 먼저 저장된 데이터 삭제 후 변경 된 결과값: " + calculator.getResults());
    }

    /**
     * 콘솔로 문자를 입력받아 결과값을 정수 또는 실수로 변환할 수 있을 때 까지 반복한다.
     * <p>변환된 수를 {@link Number}에 업캐스팅해서 반환한다.</p>
     *
     * @param sc {@link Scanner} 인스턴스
     * @return 정수 또는 실수가 업캐스팅된 {@link Number}로 반환
     */
    static Number safeNextNumber(Scanner sc) {
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

    /**
     * 콘솔로 문자를 입력받아 {@link CalculationOperator} 열거형으로 변환할 수 있을 때 까지 반복한다.
     * <p>변환된 {@link CalculationOperator} 열거형을 반환한다.</p>
     *
     * @param sc Scanner 인스턴스
     * @return {@link CalculationOperator}로 반환
     */
    static CalculationOperator safeNextOperator(Scanner sc) {
        while (true) {
            try {
                char c = sc.next().charAt(0);
                return CalculationOperator.getType(c);
            } catch (Exception e) {
                System.out.println("[Error] 올바른 사칙연산 기호를 입력해 주세요.");
                sc.nextLine();
            }
        }
    }

    /**
     * 입력된 문자열이 정수라면 참을 아니면 거짓을 반환한다.
     *
     * @param s 숫자로 이루어진 문자열
     * @return boolean
     */
    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 입력된 문자열이 실수라면 참을 아니면 거짓을 반환한다.
     *
     * @param s 숫자로 이루어진 문자열
     * @return boolean
     */
    static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 필터를 적용할 {@link List}와 필터 조건을 입력받아 필터를 진행한다.
     * <p>필터가 적용된 {@link List}를 반환한다.</p>
     *
     * @param list   필터를 적용할 List
     * @param filter 필터 조건[ex)> 4, <= 3]
     * @return 필터링 된 {@link List}
     * @throws IllegalArgumentException {@code filter}에 잘못된 필터 조건이 들어간 경우
     */
    static List<Number> getFillteredList(List<Number> list, String filter) throws IllegalArgumentException {
        // 정규식
        String regex = "^(>=|<=|==|!=|>|<) [0-9]+(\\.[0-9]+)?$";
        if (!Pattern.matches(regex, filter))
            throw new IllegalArgumentException();

        // 문자열을 공백 기준으로 스플릿
        String[] signAndNum = filter.split("\\s+");

        // 열거형 타입의 부등호로 변환
        ComparionOperator comparionOperator = ComparionOperator.fromSymbol(signAndNum[0]);
        // 숫자로 변환
        double num = Double.parseDouble(signAndNum[1]);
        // apply 함수로 두 수를 받고 조건에 따라 필터를 진행해 반환한다.
        return list.stream()
                .filter(n -> comparionOperator.apply(n, num))
                .collect(Collectors.toList());
    }


}
