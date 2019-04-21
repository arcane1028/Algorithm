package baekjoonoj.samsung_sw.problem_17144;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int map[][];
    private static int n;
    private static int m;
    private static int virus[][];
    private static int virus_size;
    private static boolean check[];
    private static int cur_test[];
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        virus = new int[10][2];
        virus_size = 0;
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    map[i][j] = -1;
                    virus[virus_size][0] = i;
                    virus[virus_size][1] = j;
                    virus_size++;
                }
            }
        }
        check = new boolean[virus_size];
        cur_test = new int[m];

        make_test(0, 0);

        if (answer == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }

    private static void make_test(int start, int index) {
        if (index == m) {
            int result = solution(cur_test);

            if (result < answer) {
                answer = result;
            }
            return;
        }

        for (int i = start; i < virus_size; i++) {
            if (!check[i]) {
                check[i] = true;
                cur_test[index] = i;
                make_test(i + 1, index + 1);
                check[i] = false;
            }
        }
    }

    private static int solution(int[] cur_test) {
        int cur_map[][] = new int[n][n];
        Queue<Point> queue = new LinkedList<>();
        int direction[][] = {
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 0}
        };

        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, cur_map[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            int x = virus[cur_test[i]][0];
            int y = virus[cur_test[i]][1];
            cur_map[x][y] = 2;
            queue.offer(new Point(x, y));
        }

        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = temp.x + direction[i][0];
                int y = temp.y + direction[i][1];
                if (y < n && y >= 0 && x < n && x >= 0) {
                    if (cur_map[x][y] == 0 || cur_map[x][y] == -1) {
                        cur_map[x][y] = cur_map[temp.x][temp.y] + 1;
                        queue.offer(new Point(x, y));
                    }
                }
            }
        }
        int max_time = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cur_map[i][j] == 0) {
                    return Integer.MAX_VALUE;
                }
                if (cur_map[i][j] != 1 && map[i][j] != -1 && cur_map[i][j] > max_time) {
                    max_time = cur_map[i][j];
                }
            }
        }
        return max_time - 2;

    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
