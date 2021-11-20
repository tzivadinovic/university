package main.Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite neki broj > ");
        int number = scanner.nextInt();
        long factorial = 1;
        if(isPrime(number)){
            System.out.println(number + " je prost broj.");
        }else{
            for (int i = 1; i <= number; i++){
                factorial *= i;
            }
            System.out.println("Broj " + number + " nije prost i njegov faktorijel je: "+ factorial);
        }
    }

    public static boolean isPrime(int number){
        for (int i = 2; i <= number / 2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

}
