package baekjoonoj.sw_test.basic.dp.problem_16194;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= n; i++) {
            int min = p[i];
            for (int j = 1; j <= (i + 1) / 2; j++) {
                min = Math.min(min, p[i - j] + p[j]);
            }
            p[i] = min;
        }

        bw.write(p[n] + "\n");

        br.close();
        bw.close();
    }
}