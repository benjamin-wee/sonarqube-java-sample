package com.uob;

public class LoanProcessor {

    // Smells: magic numbers, duplicate string literals, and System.out logging
    public String approve(double income, double debt) {
        if (debt < 0) {
            System.out.println("REJECTED"); // duplicate literal + System.out
            return "REJECTED";
        }

        if (income <= 0) {
            System.out.println("REJECTED"); // duplicate literal + System.out
            return "REJECTED";
        }

        double ratio = debt / income; // magic number thresholds below

        if (ratio < 0.40) {
            System.out.println("APPROVED"); // System.out logging
            return "APPROVED";
        } else if (ratio < 0.60) {
            System.out.println("REVIEW");   // System.out logging
            return "REVIEW";
        } else {
            System.out.println("REJECTED"); // 3rd time -> duplicate literal smell
            return "REJECTED";
        }
    }
}
