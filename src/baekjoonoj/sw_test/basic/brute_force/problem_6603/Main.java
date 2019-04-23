package baekjoonoj.sw_test.basic.brute_force.problem_6603;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int s[];
    private static final int MAX = 6;
    private static StringBuilder sb;
    private static int answer[];
    private static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = new int[MAX];
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        while (n != 0) {
            s = new int[n];
            check = new boolean[n];
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            solution(0, 0);
            sb.append("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void solution(int prev, int index) {
        if (index == MAX) {
            for (int i = 0; i < MAX; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = prev; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                answer[index] = s[i];
                solution(i, index + 1);
                check[i] = false;
            }
        }
    }
}
