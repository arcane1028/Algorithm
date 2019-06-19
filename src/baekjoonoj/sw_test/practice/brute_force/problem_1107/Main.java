package baekjoonoj.sw_test.practice.brute_force.problem_1107;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min1 = n >= 100 ? n - 100 : 100 - n; // +,- ,100인경우
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < 1_000_001; i++) {
            int l = length(i);

            if (l != 0) {
                int d = n >= i ? n - i : i - n;
                int cur = d + l;
                if (min2 > cur) {
                    min2 = cur;
                }
            }
        }

        if (min1 > min2) {
            bw.write(min2 + "\n");
        } else {
            bw.write(min1 + "\n");
        }

        br.close();
        bw.close();
    }

    private static int length(int i) {
        int length = 0;
        if (i == 0) {
            return broken[0] ? 0 : 1;
        }
        while (i > 0) {

            int r = i % 10;
            i = i / 10;
            if (broken[r]) {
                return 0;
            }
            length++;
        }
        return length;
    }
}
