package baekjoonoj.sw_test.basic.dp.problem_14002;

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

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        bw.write((result+1)+"\n");

        int t = result;
        int[] ans = new int[result+1];

        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == t){
                ans[t--] = num[i];
            }
        }
        for (int i = 0; i < result+1; i++) {
            bw.write(ans[i]+" ");
        }
        bw.newLine();
        br.close();
        bw.close();
    }
}
