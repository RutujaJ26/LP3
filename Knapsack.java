import java.util.Scanner;

public class Knapsack {

    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        // Create a 2D array to store the maximum values
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // If the weight of the current item is less than or equal to the current capacity
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // Otherwise, do not include the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity]; // Maximum value for the full capacity
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        // Input item values and weights
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + " (format: value weight): ");
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int maxValue = knapsack(capacity, weights, values, n);
        System.out.println("Maximum value in the knapsack: " + maxValue);

        scanner.close();
    }
}