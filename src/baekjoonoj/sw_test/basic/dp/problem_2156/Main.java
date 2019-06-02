package baekjoonoj.sw_test.basic.dp.problem_2156;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 3];
        int[] dp = new int[n + 3];

        for (int i = 3; i < n + 3; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 3; i < n + 3; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wine[i]), dp[i - 3] + wine[i - 1] + wine[i]);
        }

        bw.write(dp[n + 2] + "\n");

        br.close();
        bw.close();
    }
}
