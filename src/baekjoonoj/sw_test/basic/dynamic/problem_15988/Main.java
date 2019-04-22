package baekjoonoj.sw_test.basic.dynamic.problem_15988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long answer[] = new long[1000001];

        answer[0] = 1;
        answer[1] = 1;
        answer[2] = 2;

        for (int i = 3; i < 1000001; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2] + answer[i - 3]) % 1000000009;
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(answer[n] + "\n");
        }
        br.close();
        bw.close();
    }
}