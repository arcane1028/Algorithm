package baekjoonoj.sw_test.basic.bfs.problem_4963;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 2;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j, w, h);
                        count++;
                    }
                }
            }
            bw.write(count - 2+"\n");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y, int w, int h) {
        if (map[x][y] == 0) {
            return;
        }
        if (map[x][y] == 1) {
            map[x][y] = count;
        }
        int[] mov = {-1, 0, 1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x + mov[i] < 0 || x + mov[i] >= h || y + mov[j] < 0 || y + mov[j] >= w) {
                    continue;
                }
                if (map[x + mov[i]][y + mov[j]] == 1) {
                    dfs(x + mov[i], y + mov[j], w, h);
                }
            }
        }
    }
}

