package com.marchello.testing;

public class Triangle {
    static boolean isTriangleExist(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        return a < b + c && c < a + b && b < a + c;
    }
}
