package baekjoonoj.sw_test.basic.dp.problem_15990;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[][] answer = new long[100_001][4];

        answer[1][1] = 1;
        answer[2][2] = 1;
        answer[3][1] = 1;
        answer[3][2] = 1;
        answer[3][3] = 1;

        for (int i = 4; i < 100_001; i++) {
            answer[i][1] = (answer[i - 1][2] + answer[i - 1][3]) % 1_000_000_009;
            answer[i][2] = (answer[i - 2][1] + answer[i - 2][3]) % 1_000_000_009;
            answer[i][3] = (answer[i - 3][1] + answer[i - 3][2]) % 1_000_000_009;
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            bw.write((answer[n][1] + answer[n][2] + answer[n][3]) % 1_000_000_009 + "\n");
        }
        br.close();
        bw.close();
    }
}
