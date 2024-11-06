//import java.sql.Time;
//
//public class Fibonacci {
//
//    // Iterative method to calculate Fibonacci number
//    public static int fibonacciIterative(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        int a = 0, b = 1;
//        int result = 0;
//        for (int i = 2; i <= n; i++) {
//            result = a + b;
//            a = b;
//            b = result;
//        }
//        return result;
//    }
//
//    // Recursive method to calculate Fibonacci number
//    public static int fibonacciRecursive(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
//    }
//
//
//    public static void main(String[] args) {
//        int n = 10;  // Example input
//        System.out.println("Iterative Fibonacci of " + n + " is: " + fibonacciIterative(n));
//
//        int m = 10;  // Example input
//        System.out.println("Recursive Fibonacci of " + m + " is: " + fibonacciRecursive(m));
//    }
//}
//



import java.util.Scanner;

public class Fibonacci {

    // Iterative Fibonacci function with step counter
    public static int fibonacciIterative(int n, int[] steps) {
        if (n == 0) {
            steps[0] = 1;  // Base case step
            return 0;
        }
        if (n == 1) {
            steps[0] = 1;  // Base case step
            return 1;
        }

        int a = 0, b = 1, fib = 0;
        steps[0] = 2;  // Initial steps for a and b

        for (int i = 2; i <= n; i++) {
            fib = a + b;  // Fibonacci computation
            a = b;
            b = fib;
            steps[0] += 3;  // Three operations in each loop iteration
        }

        return fib;
    }

    // Recursive Fibonacci function with step counter
    static int count = 0;
    public static int fibonacciRecursive(int n) {
        count++;
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int[] steps = {0};  // Array to hold steps for iteration
        int iterativeResult = fibonacciIterative(n, steps);

        count = 0;  // Reset recursive step count
        int recursiveResult = fibonacciRecursive(n);

        // Output the results and step counts
        System.out.println("Fibonacci Value using Recursion: " + recursiveResult);
        System.out.println("Fibonacci Value using Iteration: " + iterativeResult);
        System.out.println("Steps required using Recursion: " + count);
        System.out.println("Steps required using Iteration: " + steps[0]);

        scanner.close();
}
}










//Iterative Approach - Time Complexity: O(n)
//                     Space Complexity: O(1)
//
//Recursive Approach - Time Complexity: O(n^2)
//                     Space Complexity:O(n)