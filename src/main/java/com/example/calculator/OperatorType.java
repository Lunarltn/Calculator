package com.example.calculator;

public enum OperatorType {
    SUM('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char symbol;

    OperatorType(char c) {
        this.symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperatorType getType(char c) {
        for (OperatorType type : values()) {
            if (type.symbol == c) {
                return type;
            }
        }
        throw new IllegalArgumentException("[Error] 올바른 사칙연산 기호를 입력해 주세요.: " + c);
    }
}