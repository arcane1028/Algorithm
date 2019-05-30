package baekjoonoj.sw_test.basic.dp.problem_11057;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10];

        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % 10_007;
            }
        }
        bw.write(dp[9] + "\n");
        br.close();
        bw.close();
    }
}
/*
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10_007;
                }
            }

        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % 10_007;
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
* */