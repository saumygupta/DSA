import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int X = scanner.nextInt(); // Cost of mess food per day
        int Y = scanner.nextInt(); // Cost of restaurant meal

        // Calculate the weekly cost
        int weeklyCost = 6 * X + Y;

        // Output the result
        System.out.println(weeklyCost);

        scanner.close();
    }
}