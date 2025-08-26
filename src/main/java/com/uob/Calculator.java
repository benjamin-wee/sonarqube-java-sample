package com.uob;

public class Calculator {
    public int divide(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) { // empty catch block
        }
    }

    public int lenOrZero(String s) {
        if (s != null || s.length() == 0) { // Noncompliant: may dereference null
            return s.length();
        }
        return 0;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("len(null) -> " + c.lenOrZero(null)); // triggers the bug
    }
}
