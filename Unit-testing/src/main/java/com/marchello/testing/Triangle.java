package com.marchello.testing;

public class Triangle {
    private static final String NEGATIVE_OR_ZERO_LENGTH_SIDE = "The triangle has negative or zero sides";
    static boolean isTriangleExist(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException(NEGATIVE_OR_ZERO_LENGTH_SIDE);
        return a < b + c && c < a + b && b < a + c;
    }
}
