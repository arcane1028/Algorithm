package baekjoonoj.sw_test.practice.brute_force.problem_14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] s;
    private static int min;
    private static boolean[] visited;
    private static int[] t_start = new int[n / 2];
    private static int[] t_link = new int[n / 2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        min = Integer.MAX_VALUE;
        visited = new boolean[n];
        t_start = new int[n / 2];
        t_link = new int[n / 2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            t_start[0] = i;
            dfs(i, 0);
        }


        bw.write(min + "\n");

        bw.close();
        br.close();
    }

    private static void dfs(int cur, int idx) {
        if (idx == n / 2 - 1) {
            int s_start = 0, s_link = 0;
            int ti = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                t_link[ti++] = i;
            }

            for (int i = 0; i < n / 2; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    int si = t_start[i], sj = t_start[j];
                    int li = t_link[i], lj = t_link[j];
                    s_start += s[si][sj] + s[sj][si];
                    s_link += s[li][lj] + s[lj][li];
                }
            }
            int d = s_start > s_link ? s_start - s_link : s_link - s_start;
            if (min > d) {
                min = d;
            }

        } else {
            for (int i = cur + 1; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                t_start[idx+1] = i;
                dfs(i, idx + 1);
            }
        }
        visited[cur] = false;
    }
}