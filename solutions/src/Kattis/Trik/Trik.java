import java.util.Scanner;

/**
 * Solution to Trik problem on Kattis Problem found on:
 * https://open.kattis.com/problems/trik
 */
public class Trik {

    public static void main(String[] args) {

        //Take input and parse into char array.
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        int ans = 1;

        // Loop through all the commands and update the answer at every iteration;
        // Do nothing if the ball is not in one of the moved cups.
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'A') {
                if (ans == 1) {
                    ans = 2;
                } else if (ans == 2) {
                    ans = 1;
                }
            } else if (input[i] == 'B') {
                if (ans == 2) {
                    ans = 3;
                } else if (ans == 3) {
                    ans = 2;
                }
            } else {
                if (ans == 3) {
                    ans = 1;
                } else if (ans == 1) {
                    ans = 3;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
