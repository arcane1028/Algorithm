package baekjoonoj.sw_test.basic.dp.problem_11055;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur_max = 0;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    if (dp[j] > cur_max) {
                        cur_max = dp[j];
                    }
                }
            }
            dp[i] = cur_max + num[i];
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        bw.write(max + "\n");

        br.close();
        bw.close();
    }
}
