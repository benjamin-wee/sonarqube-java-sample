package com.uob;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class HelloBank {

    // Vulnerability: weak hashing algorithm (MD5)
    public static String weakHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // Noncompliant
            byte[] digest = md.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            return ""; // not relevant; demo only
        }
    }

    // Vulnerability: predictable Random for security-sensitive value
    public static String issueOtp() {
        Random r = new Random(); // Noncompliant
        int otp = 100000 + r.nextInt(900000);
        return String.valueOf(otp);
    }

    public static void main(String[] args) {
        System.out.println("Weak hash of 'secret' = " + weakHash("secret"));
        System.out.println("OTP = " + issueOtp());
    }
}
