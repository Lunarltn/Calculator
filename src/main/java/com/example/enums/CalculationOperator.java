package com.example.enums;

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

    public static CalculationOperator getType(char c) {
        for (CalculationOperator type : values()) {
            if (type.symbol == c) {
                return type;
            }
        }
        throw new IllegalArgumentException("[Error] 올바른 사칙연산 기호를 입력해 주세요.: " + c);
    }
}