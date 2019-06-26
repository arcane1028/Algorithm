package baekjoonoj.sw_test.practice.brute_force.problem_9663;

import java.io.*;

public class Main {

    private static int n;
    private static boolean[] visited_row;
    private static boolean[] visited_dia1;
    private static boolean[] visited_dia2;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        visited_row = new boolean[n];
        visited_dia1 = new boolean[n + n - 1];
        visited_dia2 = new boolean[n + n - 1];
        answer = 0;
        dfs(0);

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    private static void dfs(int idx) {
        if (idx == n) {
            answer += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited_row[i]) {
                continue;
            }
            if (visited_dia1[i - idx + n - 1]) {
                continue;
            }
            if (visited_dia2[i + idx]) {
                continue;
            }
            visited_row[i] = true;
            visited_dia1[i - idx + n - 1] = true;
            visited_dia2[i + idx] = true;
            dfs(idx + 1);
            visited_row[i] = false;
            visited_dia1[i - idx + n - 1] = false;
            visited_dia2[i + idx] = false;
        }
    }
}
