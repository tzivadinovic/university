package main.Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Unesite broj: ");
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int reverse = 0;
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        System.out.println(reverse);
    }
}
