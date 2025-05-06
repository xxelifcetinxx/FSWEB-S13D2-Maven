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

        numberToWords(123);    // One Two Three
        numberToWords(1010);   // One Zero One Zero
        numberToWords(-12);    // Invalid Value
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



    // 3. Sayıları Kelimelere Dökme
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        if (number == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        int reversed = reverse(number);
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversed);

        while (reversed > 0) {
            int digit = reversed % 10;
            result.append(getWordForDigit(digit)).append(" ");
            reversed /= 10;
        }

        // Eksik sıfırlar varsa onları da ekle
        for (int i = 0; i < originalDigitCount - reversedDigitCount; i++) {
            result.append("Zero ");
        }

        return result.toString().trim(); // En sondaki boşluğu sil
    }

    // Sayıyı ters çevir
    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }

    //  Rakam sayısı
    public static int getDigitCount(int number) {
        if (number == 0) return 1;
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    //Rakamı kelimeye çevir
    public static String getWordForDigit(int digit) {
        return switch (digit) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "";
        };
    }

}
