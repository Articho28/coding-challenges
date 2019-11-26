import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

/**
 * Problem found on Kattis:
 * https://open.kattis.com/problems/guessthedatastructure 
 */


public class GuessTheDatastructure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            int n = Integer.parseInt(input);

            //Initialize data structures
            Stack<Integer> stack = new Stack<Integer>();
            Queue<Integer> queue = new LinkedList<Integer>();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;

            //Start recording Sequence
            for (int i = 0; i < n; i++) {

                //Parse input on the next line
                String[] nextInput = sc.nextLine().split(" ");
                int command = Integer.parseInt(nextInput[0]);
                int val = Integer.parseInt(nextInput[1]);

                // If the command is one, add to each data structure
                if (command == 1) {
                    stack.add(val);
                    queue.add(val);
                    pq.add(val);

                } else {
                    if (!stack.isEmpty()) {
                        int stackVal = (int) stack.pop();
                        if (val != stackVal) isStack = false;
                    } else {
                        isStack = false;
                    }
                    if (!queue.isEmpty()) {
                        int queueVal = (int) queue.remove();
                        if (val != queueVal) isQueue = false;
                    } else {
                        isQueue = false;
                    }
                    if (!pq.isEmpty()) {
                        int pqVal = (int) pq.remove();
                        if (val != pqVal) isPQ = false;
                    } else {
                        isPQ = false;
                    }
                }
            }

            //Check for matches
            if (isStack && !isQueue && !isPQ) {
                System.out.println("stack");
            } else if (isQueue && !isStack && !isPQ) {
                System.out.println("queue");
            } else if (isPQ && !isStack && !isQueue) {
                System.out.println("priority queue");
            } else if (!isStack && !isQueue && !isPQ) {
                System.out.println("impossible");
            } else {
                System.out.println("not sure");
            }
        }
        sc.close();
    }
}
