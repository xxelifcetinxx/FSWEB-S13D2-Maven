package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));  // true
        System.out.println(isPalindrome(707));    // true
        System.out.println(isPalindrome(11212));  // false

        System.out.println(isPerfectNumber(6));   // true
        System.out.println(isPerfectNumber(28));  // true
        System.out.println(isPerfectNumber(5));   // false
        System.out.println(isPerfectNumber(-1));  // false


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

    // 2. Mükemmel Sayı Kontrolü
    public static boolean isPerfectNumber(int number) {
        if (number < 1) return false;

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }




}
