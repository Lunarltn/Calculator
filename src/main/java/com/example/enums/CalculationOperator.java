package com.example.enums;

/**
 * 사칙연산에 사용되는 연산자 타입을 정의한 열거형
 *
 * <p>각 연산자는 해당 연산을 나타내는 기호 문자('+', '-', '*', '/')와 함께 정의된다.</p>
 */
public enum CalculationOperator {
    SUM('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char symbol;

    CalculationOperator(char c) {
        this.symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }

    /**
     * 사칙 연산 기호를 {@code char}로 받아 {@link CalculationOperator} 타입으로 변환한다.
     *
     * @param symbol 사칙 연산자('+', '-', '*', '/')
     * @return 입력받은 사칙 연산자 {@code symbol}에 맞는 {@link CalculationOperator}로 반환
     * @throws IllegalArgumentException {@code symbol}에 맞는 연산자가 없는 경우
     */
    public static CalculationOperator getType(char symbol) throws IllegalArgumentException {
        for (CalculationOperator type : values()) {
            if (type.getSymbol() == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("[Error] 올바른 사칙연산 기호를 입력해 주세요.: " + symbol);
    }
}