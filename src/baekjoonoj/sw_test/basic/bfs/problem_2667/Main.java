package baekjoonoj.sw_test.basic.bfs.problem_2667;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static int[][] map;
    private static int n;
    private static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = (s.charAt(j) == '0') ? 0 : 1;

            }
        }
        number = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                    number++;
                }
            }
        }

        int[] answer = new int[number];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[map[i][j]]++;
            }
        }

        bw.write((number - 2) + "\n");
        Arrays.sort(answer, 2, number);
        for (int i = 2; i < number; i++) {
            bw.write(answer[i] + "\n");
        }


        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        if (map[x][y] == 0) {
            return;
        }
        if (map[x][y] == 1) {
            map[x][y] = number;
        }
        if (x + 1 < n && map[x + 1][y] == 1) {
            dfs(x + 1, y);
        }
        if (y + 1 < n && map[x][y + 1] == 1) {
            dfs(x, y + 1);
        }
        if (x - 1 >= 0 && map[x - 1][y] == 1) {
            dfs(x - 1, y);
        }
        if (y - 1 >= 0 && map[x][y - 1] == 1) {
            dfs(x, y - 1);
        }
    }
}
