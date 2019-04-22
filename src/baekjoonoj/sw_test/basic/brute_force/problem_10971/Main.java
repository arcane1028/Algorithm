package baekjoonoj.sw_test.basic.brute_force.problem_10971;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int w[][];
    private static int n;
    private static boolean visited[];
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        w = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st;
        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            solution(i, i, 1, 0);
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static void solution(int start, int cur_city, int len, int total) {
        if (len == n) {
            if (!visited[start] && w[cur_city][start] != 0) {
                total += w[cur_city][start];
                if (total < answer) {
                    answer = total;
                }
                total -= w[cur_city][start];
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i != start && w[cur_city][i] != 0 && !visited[i]) {
                visited[i] = true;
                total += w[cur_city][i];
                solution(start, i, len + 1, total);
                visited[i] = false;
                total -= w[cur_city][i];
            }
        }
    }
}
