package com.app.main;

import com.math.utils.Calculator;

public class MainApp {
    public static void main(String[] args) {

        int sum = Calculator.add(5, 3);
        int product = Calculator.multiply(5, 3);
        String original = "naman";
        String reversed = com.string.utils.TextUtils.reverse(original);
        boolean isPalindrome = com.string.utils.TextUtils.isPalindrome(original);

        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}