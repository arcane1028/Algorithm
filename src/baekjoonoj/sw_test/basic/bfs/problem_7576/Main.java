package baekjoonoj.sw_test.basic.bfs.problem_7576;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];

                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m) {
                    if (box[next_x][next_y] == 0) {
                        box[next_x][next_y] = box[cur.x][cur.y] + 1;
                        queue.offer(new Pair(next_x, next_y));
                    }
                }
            }
        }
        boolean isEnd = true;
        int answer = 1;

        first:for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    isEnd = false;
                    break first;
                }
                if (box[i][j] > answer) {
                    answer = box[i][j];
                }
            }
        }
        if (isEnd) {
            bw.write((answer - 1) + "\n");
        } else {
            bw.write("-1\n");
        }

        br.close();
        bw.close();
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
