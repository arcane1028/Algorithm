package baekjoonoj.sw_test.basic.dp.problem_13398;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 2; i < n + 2; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][n + 2];

        int answer = Integer.MIN_VALUE;

        for (int i = 2; i < n + 2; i++) {

            dp[0][i] = Math.max(dp[0][i - 1] + num[i], num[i]);
            dp[1][i] = Math.max(dp[0][i - 2] + num[i], dp[1][i - 1] + num[i]);

            answer = Math.max(Math.max(dp[0][i], dp[1][i]), answer);
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
