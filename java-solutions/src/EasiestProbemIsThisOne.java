import java.util.Scanner;

/**
 * Problem from Kattis: The Easiest Problem Is This One
 * Source: https://open.kattis.com/submissions/4609838
 */
public class EasiestProbemIsThisOne {

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        //Put in a while loop to continue there are values to process
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int target = getSumOfDigits(n);

            //Only iterate up to N / Max Value to avoid overflow
            for (int i = 11; i < Integer.MAX_VALUE / n; i++) {
                if (getSumOfDigits(n*i) == target) {
                    System.out.println(i);
                    break;
                }
            }

        }


    }

    public static int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit;
            num = num / 10;
        }
        return sum;
    }
}
