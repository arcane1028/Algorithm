package baekjoonoj.sw_test.basic.bfs.problem_3055;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        Pair s = null;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String t = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = t.charAt(j);
                if (map[i][j] == 'S') {
                    s = new Pair('S', i, j, 0);
                    map[i][j] = '.';
                }
                if (map[i][j] == '*') {
                    queue.offer(new Pair('*', i, j, 0));
                }
            }
        }
        queue.offer(s);

        int answer = -1;
        answer = bfs(r, c, map, queue);

        if (answer == -1) {
            bw.write("KAKTUS\n");
        } else {
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }

    private static int bfs(int r, int c, char[][] map, Queue<Pair> queue) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] visited = new boolean[r][c];

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];

                if (next_x < 0 || next_x >= r || next_y < 0 || next_y >= c) {
                    continue;
                }
                if (cur.type == '*' && map[next_x][next_y] == '.') {
                    map[next_x][next_y] = '*';
                    queue.offer(new Pair('*', next_x, next_y, cur.dis + 1));
                } else if (cur.type == 'S' && map[next_x][next_y] == '.' && !visited[next_x][next_y]) {
                    visited[next_x][next_y] = true;
                    queue.offer(new Pair('S', next_x, next_y, cur.dis + 1));
                } else if (cur.type == 'S' && map[next_x][next_y] == 'D') {
                    return cur.dis + 1;
                }
            }
            if (!queue.isEmpty()) {
                if (cur.type == '*' && queue.peek().type == '*' && queue.peek().dis != cur.dis) {
                    return -1;
                }
            }
        }
        return -1;
    }
}

class Pair {
    char type;
    int x;
    int y;
    int dis;

    Pair(char type, int x, int y, int dis) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
