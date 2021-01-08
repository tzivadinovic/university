package main;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 1, 5, 5, 2, 5, 5};
        System.out.println("Zadatak 16");
        System.out.println("");
        System.out.println("Postoji, broj je: " + repeatingElementInArray(arr));
    }

    public static int repeatingElementInArray(int[] arr) {
        int current = arr[0], counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (current == arr[i]) {
                counter++;
            } else if (counter == 0) {
                current = arr[i];
                counter++;
            } else {
                counter--;
            }
        }
        return current;
    }
}
