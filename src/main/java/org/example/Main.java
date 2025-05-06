package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));  // true
        System.out.println(isPalindrome(707));    // true
        System.out.println(isPalindrome(11212));  // false
    }

    // 1. Palindrom Sayı Kontrolü
    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        int original = number;
        int reversed = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }

        return original == reversed;
    }




}
