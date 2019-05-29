package baekjoonoj.sw_test.basic.dp.problem_10844;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            dp[i + 1][1] += dp[i][0];
            for (int j = 1; j < 9; j++) {
                dp[i + 1][j - 1] = (dp[i + 1][j - 1] + dp[i][j]) % 1_000_000_000;
                dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % 1_000_000_000;
            }
            dp[i + 1][8] += dp[i][9];
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % 1_000_000_000;
        }
        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}
