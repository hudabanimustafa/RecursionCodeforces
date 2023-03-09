import java.util.*;
import java.io.*;


// problem C. Guess Your Way Out!
// Student Huda BM
// " https://codeforces.com/contest/507/problem/C "
// recursion training
public class Guess {
    static final int LEFT = 0;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        long h = sc.nextLong();
        long n = sc.nextLong();

        System.out.println(compute(h, n, 1));
    }

    static long compute(long h, long n, int cur) {
        assert (n >= 0);

        if (h == 0)
            return 0;

        long half = 1L << (h - 1);

        if (n <= half) {
            if (cur != LEFT)
                return 1 + compute(h - 1, n, 0);
            else
                return 2 * half + compute(h - 1, n, 0);
        } else {
            if (cur != LEFT)
                return 2 * half + compute(h - 1, n - half, 1);
            else
                return 1 + compute(h - 1, n - half, 1);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
