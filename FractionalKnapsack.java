import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    double value;
    double weight;
    double costPerWeight;

    Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
        this.costPerWeight = value / weight;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(double capacity, Item[] items) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                return Double.compare(b.costPerWeight, a.costPerWeight);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) {
                break; // Knapsack is full
            }

            if (item.weight <= capacity) {
                // Take the whole item
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take the fraction of the item that fits
                totalValue += item.costPerWeight * capacity;
                capacity = 0; // Knapsack is now full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        // Input item values and weights
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + " (format: value weight): ");
            double value = scanner.nextDouble();
            double weight = scanner.nextDouble();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();

        double maxValue = fractionalKnapsack(capacity, items);
        System.out.printf("Maximum value in the knapsack: %.2f\n", maxValue);

        scanner.close();
    }
}