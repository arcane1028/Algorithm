package baekjoonoj.sw_test.basic.n_and_m.problem_15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb;
    private static int m;
    private static int n;
    private static boolean check[];
    private static int a[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];
        a = new int[m];
        sb = new StringBuilder();

        solution(0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void solution(int index) {
        if (index == m) {
            for (int i = 0; i < m - 1; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append(a[m - 1]).append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            a[index] = i;
            solution(index + 1);
            check[i] = false;
        }
    }
}
