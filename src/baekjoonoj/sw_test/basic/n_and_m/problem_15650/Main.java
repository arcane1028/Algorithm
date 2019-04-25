package baekjoonoj.sw_test.basic.n_and_m.problem_15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int seq[];
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[m];
        sb = new StringBuilder();

        solution(1, 0);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void solution(int start, int len) {
        if (len == m) {
            for (int i = 0; i < m; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            seq[len] = i;
            solution(i + 1, len + 1);
        }
    }
}
