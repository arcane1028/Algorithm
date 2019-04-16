package baekjoonoj.sw_test.basic.problem_1260;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static StringBuilder sb;
    private static boolean edge[][];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        edge = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge[e1][e2] = edge[e2][e1] = true;
        }
        visited = new boolean[n + 1];
        sb = new StringBuilder();
        dfs(v);
        for (int i = 0; i < n + 1; i++) {
            visited[i] = false;
        }

        bfs(v);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            v = q.poll();
            sb.append(v).append(" ");
            for (int i = 1; i <= n; i++) {
                if (edge[v][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }


    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i <= n; i++) {
            if (edge[v][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}