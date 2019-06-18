package baekjoonoj.sw_test.basic.dp.problem_2225;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k == 1) {
            bw.write("1\n");
        } else {
            long[][] dp = new long[n + 1][k];
            long sum = 0;
            for (int i = 0; i <= n; i++) {
                dp[i][1] = 1;
            }
            for (int i = 0; i < k; i++) {
                dp[0][i] = 1;
            }

            for (int i = 2; i < k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[j][i] = (dp[j][i - 1] + dp[j - 1][i]) % 1_000_000_000;
                }
            }

            for (int i = 0; i <= n; i++) {
                sum = (sum + dp[i][k - 1]) % 1_000_000_000;
            }

            bw.write(sum + "\n");
        }

        br.close();
        bw.close();
    }
}
