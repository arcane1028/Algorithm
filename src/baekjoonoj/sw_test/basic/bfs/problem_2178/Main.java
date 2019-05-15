package baekjoonoj.sw_test.basic.bfs.problem_2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == '1') {
                    map[i][j] = true;
                }
                j++;
            }
        }

        int answer = bfs(n, m, map);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static int bfs(int n, int m, boolean[][] map) {
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(0, 0));
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            int d = visited[x][y];
            if (x - 1 >= 0 && map[x - 1][y] && visited[x - 1][y] == 0) {
                visited[x - 1][y] = d + 1;
                queue.offer(new Pair(x - 1, y));
            }
            if (y - 1 >= 0 && map[x][y - 1] && visited[x][y - 1] == 0) {
                visited[x][y - 1] = d + 1;
                queue.offer(new Pair(x, y - 1));
            }
            if (x + 1 < n && map[x + 1][y] && visited[x + 1][y] == 0) {
                visited[x + 1][y] = d + 1;
                queue.offer(new Pair(x + 1, y));
            }
            if (y + 1 < m && map[x][y + 1] && visited[x][y + 1] == 0) {
                visited[x][y + 1] = d + 1;
                queue.offer(new Pair(x, y + 1));
            }
        }

        return visited[n - 1][m - 1];
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