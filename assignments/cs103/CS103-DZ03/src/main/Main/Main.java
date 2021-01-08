package main.Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Unesite binarni zapis nekog broja: ");
            String binInput = scan.next();
            System.out.println("Dekadna vrednost unetog broja = " + binaryToDecimal(binInput));
        }

        public static int binaryToDecimal (String binInput){
            int len = binInput.length();
            if (len == 0) return 0;
            String now = binInput.substring(0, 1);
            String later = binInput.substring(1);
            return Integer.parseInt(now) * (int) Math.pow(2, len - 1) + binaryToDecimal(later);
        }
    }

