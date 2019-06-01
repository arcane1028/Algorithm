package baekjoonoj.sw_test.basic.dp.problem_9465;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[][] sticker = new int[2][100_003];
        int[][] dp = new int[2][100_003];
        StringTokenizer st;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 2; j < n + 2; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i < n + 2; i++) {
                dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1] + sticker[0][i]), dp[1][i - 2] + sticker[0][i]);
                dp[1][i] = Math.max(Math.max(dp[1][i - 1], dp[0][i - 1] + sticker[1][i]), dp[0][i - 2] + sticker[1][i]);
            }
            bw.write(Math.max(dp[0][n + 1], dp[1][n + 1]) + "\n");
        }
        br.close();
        bw.close();
    }
}
