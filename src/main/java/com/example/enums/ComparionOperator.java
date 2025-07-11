package com.example.enums;

public enum ComparionOperator {
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    EQUAL("=="),
    NOT_EQUAL("!=");

    private final String symbol;

    ComparionOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static ComparionOperator fromSymbol(String symbol) {
        for (ComparionOperator operator : ComparionOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("[Error] 올바른 부호를 입력해 주세요.: " + symbol);
    }

    public boolean apply(Number a, Number b) {
        double an = a.doubleValue();
        double bn = b.doubleValue();
        return switch (this) {
            case GREATER_THAN -> an > bn;
            case GREATER_THAN_OR_EQUAL -> an >= bn;
            case LESS_THAN -> an < bn;
            case LESS_THAN_OR_EQUAL -> an <= bn;
            case EQUAL -> an == bn;
            case NOT_EQUAL -> an != bn;
        };
    }
}
