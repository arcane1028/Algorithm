package baekjoonoj.sw_test.basic.bfs.problem_2206;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int m;
    private static int n;
    private static int[][] maze;
    private static boolean[][][] visited;
    private final static int[] dx = {0, 0, 1, -1};
    private final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            char[] t = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = t[j] == '1' ? 1 : 0;
            }
        }

        int answer = bfs();

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }


    private static int bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.dis;
            }
            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];

                if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) {
                    continue;
                }
                if (!visited[next_x][next_y][cur.wall] && maze[next_x][next_y] == 0) {
                    visited[next_x][next_y][cur.wall] = true;
                    queue.offer(new Pair(next_x, next_y, cur.wall, cur.dis + 1));
                } else if (maze[next_x][next_y] == 1 && cur.wall == 0) {
                    visited[next_x][next_y][1] = true;
                    queue.offer(new Pair(next_x, next_y, 1, cur.dis + 1));
                }
            }
        }
        return -1;
    }
}

class Pair {
    int x;
    int y;
    int wall;
    int dis;

    Pair(int x, int y, int wall, int dis) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.dis = dis;
    }
}