package baekjoonoj.sw_test.basic.dp.problem_1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = num[0];
        for (int i = 1; i < n; i++) {
            if (num[i] > num[i] + dp[i - 1]) {
                dp[i] = num[i];
            } else {
                dp[i] = dp[i - 1] + num[i];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
