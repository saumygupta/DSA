import java.util.Scanner;

public class Q1 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int H = scanner.nextInt();
            if (H == 0) break;
            int[] values = new int[(1 << H) - 1];
            for (int i = 0; i < values.length; i++) {
                values[i] = scanner.nextInt();
            }
            System.out.println(calculateP1(values, 0));
        }
        scanner.close();
    }

    static int calculateP1(int[] values, int index) {
        if (index >= values.length) return 0;
        if (2 * index + 1 >= values.length) return values[index];

        long left = calculateP1(values, 2 * index + 1);
        long right = calculateP1(values, 2 * index + 2);

        long maxChildProduct = Math.max(values[index] * left, values[index] * right);
        return (int) (maxChildProduct % MOD);
    }
}