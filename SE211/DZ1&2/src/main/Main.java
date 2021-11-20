package main;

public class Main {

    public static void main(String[] args) {
        int num = 12;

        if (num < 100 && num >= 1) {
            System.out.println("Its a two digit number");
        } else if (num > 99 && num <= 1000) {
            System.out.println("Its a three digit number");
        } else if (num < 10000 && num >= 1000) {
            System.out.println("Its a four digit number");
        } else if (num < 100000 && num >= 10000) {
            System.out.println("Its a five digit number");
        } else {
            System.out.println("Number is not between 1 & 99999");
        }

        System.out.println(sum(5, 5));
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
