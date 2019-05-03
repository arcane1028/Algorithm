package baekjoonoj.sw_test.basic.n_and_m.problem_15664;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int seq[];
    private static int num[];
    private static boolean visited[];
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[m];
        num = new int[n];
        visited = new boolean[n];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        solution(0, 0);

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
        int prev = -1;
        for (int i = start; i < n; i++) {
            if (visited[i] || (prev == num[i])) {
                continue;
            }
            prev = num[i];
            visited[i] = true;
            seq[len] = num[i];
            solution(i + 1, len + 1);
            visited[i] = false;
        }
    }
}
