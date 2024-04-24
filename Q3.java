import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3 {
    static int[] tree = new int[2000000000];
    static int[] blackCount = new int[2000000000];
    static int[] redCount = new int[2000000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            if (query.equals("Qi")) {
                flipColors(1);
            } else {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (query.equals("Qb")) {
                    System.out.println(countBlack(x, y));
                } else {
                    System.out.println(countRed(x, y));
                }
            }
        }
    }

    static void flipColors(int node) {
        if (tree[node] == 0) {
            tree[node] = 1;
        } else {
            tree[node] = 0;
        }

        if (2 * node < tree.length) {
            flipColors(2 * node);
            flipColors(2 * node + 1);
        }
    }

    static int countBlack(int x, int y) {
        return countColor(x, y, 0);
    }

    static int countRed(int x, int y) {
        return countColor(x, y, 1);
    }

    static int countColor(int x, int y, int color) {
        if (x == y) {
            return tree[x] == color ? 1 : 0;
        }

        int result = 0;
        while (x <= y) {
            if (x % 2 == 1) {
                result += tree[x] == color ? 1 : 0;
            }
            if (y % 2 == 0) {
                result += tree[y] == color ? 1 : 0;
            }
            x = (x + 1) / 2;
            y = (y - 1) / 2;
        }
        return result;
    }
}