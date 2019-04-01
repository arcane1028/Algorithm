package baekjoonoj.divide_conquer.problem_11729;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int k = 0;
        for (int i = 0; i < N; i++) {
            k = 2 * k + 1;
        }
        StringBuilder sb = new StringBuilder();
        bw.write(k + "\n");

        move(sb, 1, 2, 3, N);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void move(StringBuilder sb, int start, int mid, int end, int n) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        move(sb, start, end, mid, n - 1);
        sb.append(start).append(" ").append(end).append("\n");
        move(sb, mid, start, end, n - 1);
        return;
    }
}
