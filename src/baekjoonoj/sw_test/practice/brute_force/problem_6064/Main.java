package baekjoonoj.sw_test.practice.brute_force.problem_6064;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = m * n / gcd(m, n);

            boolean end = true;
            for (int cur_x = x; cur_x < lcm; cur_x += m) {
                if (cur_x % n == y || (cur_x % n == 0 && y == n)) {
                    bw.write(cur_x + "\n");
                    end = false;
                    break;
                }
            }
            if (end) {
                bw.write("-1\n");
            }
        }

        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}