package baekjoonoj.sw_test.basic.dp.problem_11722;

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[j] <= num[i]) {
                    dp[j] = num[i];
                    break;
                }
            }
        }
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == 0) {
                break;
            }
            answer++;
        }
        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}
