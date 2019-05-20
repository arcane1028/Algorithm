package baekjoonoj.sw_test.basic.bfs.problem_1261;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int m;
    private static int n;
    private static int[][] maze;
    private static int[][] counts;
    private final static int[] dx = {0, 0, 1, -1};
    private final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        counts = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] t = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = t[j] == '1' ? 1 : 0;
                counts[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();

        bw.write(counts[n - 1][m - 1] + "\n");
        br.close();
        bw.close();
    }


    private static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0));
        counts[0][0] = 0;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (counts[cur.x][cur.y] < cur.count) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];

                if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) {
                    continue;
                }
                if (counts[next_x][next_y] < cur.count) {
                    continue;
                }
                int next_count = cur.count + maze[next_x][next_y];
                if (counts[next_x][next_y] > next_count) {
                    counts[next_x][next_y] = next_count;
                    queue.offer(new Pair(next_x, next_y, next_count));
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;
    int count;

    public Pair(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

